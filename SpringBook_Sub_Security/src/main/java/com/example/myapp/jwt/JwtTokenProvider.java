package com.example.myapp.jwt;

import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.myapp.member.model.Member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/*
 * Lombok 이 제공하는 @Slf4j 를 이용하면 편리하게 log 를 찍을 수 있다.
 */
@Slf4j
public class JwtTokenProvider {
	
	/*
	 * 암호화 알고리즘을 가지고 있는 SIG 를 가져와서 알고리즘을 지정해준다.
	 * 알고리즘을 가져와서 key 를 build 해서 Key 를 생성한 것을 볼 수 있다.
	 */
	private static MacAlgorithm alg = Jwts.SIG.HS256;
	private static SecretKey key = alg.key().build();
	
	/*
	 * id 는 아래에서 보는 것과 같이 UUID 를 이용해서 랜덤으로 만들어서 사용하거나
	 * id = "qwrtyuiop" 이런 식으로 저장해서 사용하기도 한다.
	 * 우리의 경우, MacAlgorithm 을 사용해서 만들었기 때문에 id 는 필요하지 않다.
	 */
	private static String id = UUID.randomUUID().toString();
	
	/*
	 * 30 분 동안만 유효하도록 설정 한다.
	 */
	private long tokenValidTime = 30*60*1000L; 
	
	/*
	 * UserDetailsService 를 Member에서 만들었던 것처럼 
	 * UserDetailsService 타입의 변수를 만들어야 한다.
	 */
	@Autowired
	UserDetailsService userDetailsService;
	
	/*
	 * @Slf4j, @Log4j 와 같은 것을 사용하면 아래와 같이, log. 으로 바로 사용할 수 있다.
	 */
	@PostConstruct
	public void init() {
		log.debug("token provider bean created");
	}
	
	/*
	 * 토큰이 가져야할 정보는 우선,,,
	 * Header(알고리즘과 타입), Payload(클레임들), Signature 를 가져야 합니다. 
	 * 이 3가지를 가지는 Token 을 만들면 되는 것이죠. 
	 */
	public String generateToken(Member member) {
		/*
		 * 우선, ClaimsBuilder 를 반환하는 claims() 를 사용합니다.
		 * 
		 * 그리고, Member 객체를 매개변수로 받아서, Token 을 만드는 것이죠.
		 * 
		 * expiration 은 현재 시간에서 tokenValidTime 을 설정한 것을 저장해주었습니다.
		 * 
		 * claims 에 기본적인 메서드로 넣을 수 없는 것을 넣어주고 싶다면,
		 * 아래에서 보는 것과 같이 add 를 이용하면 되겠습니다. 
		 */
		long now = System.currentTimeMillis();
		Claims claims = Jwts.claims()
				.subject(member.getUserid())
				.issuer(member.getName())
				.expiration(new Date(now + tokenValidTime))
				.issuedAt(new Date(now))
				.add("roles", member.getRole())
				.build();
		
		/*
		 * claims 로 만든 클래임들을 넣어주고, 
		 * sighWith 로 key 와 alg 를 지정해주고 반환해주면 됩니다.
		 * 우리의 경우에는 사실 key 만 넣어주어도 되는데요. 
		 * MacAlgorithm 은 문자열 없이 키만 있어도 동작하기 때문에 그렇습니다.
		 * 
		 * signWith 메서드 중에는 SignatureAlgorithm 과 byte[] secretKey 를 매개변수로
		 * 받는 메서드도 있습니다. 그런데, 사실, key 를 문자열로 넣는 것은 굉장히 
		 * 부담스러운 일입니다. 그래서 우리는 UUID를 만들어서 그것을 key 로 사용을 하는데요.
		 * 이것조차도 귀찮으니까 MacAlgorithm 과 같은 것들은 이런 것도 자동으로 해주는 것이죠.
		 */
		return Jwts.builder()
				.claims(claims)
				.signWith(key, alg)
				.compact();
	}
	
	/*
	 * JwtAuthenticationFilter 에서 사용할 메서드들을 만들어줘야 합니다.
	 * 우선, Request Header 에서 토큰을 꺼내오는 메서드를 작성합니다.
	 */
	public String resolveToken(HttpServletRequest requset) {
		return requset.getHeader("X-AUTH-TOKEN");
	}
	
	/*
	 * JwtAuthenticationFilter 에서 사용할 메서드들을 만들어줘야 합니다.
	 * 토큰이 유효한지 확인하는 메서드를 작성합니다.
	 */
	public boolean validateToken(String token) {
		try {
			/*
			 * token 을 가져와서, Jwts의 parser 메서드를 이용하여 유효성을 확인하게 되는데요.
			 * verifyWith key 를 사용해서 얘가 key 로 암호화된 
			 * token인지 유효성을 확인한 다음에, 
			 * token 을 parse 하게 됩니다. 
			 */
			Jws<Claims> claims = Jwts.parser()
					.verifyWith(key)
					.build()
					.parseSignedClaims(token);
			
			/*
			 * 유효성 검사가 끝났다면, 이번에는 만료일 검사를 해야 합니다. 
			 * 만료일 보다 전이라면, False 가 나가야하고, 
			 * 만료일 보다 후라면, True 가 나와야 겠습니다. 
			 */
			return !claims
					.getPayload()
					.getExpiration()
					.before(new Date());
		} catch (Exception e) {
			/*
			 * 토큰을 유효성 검사하는 동안 어떠한 에러가 발생하더라도 
			 * 모두 return false 를 하면 되겠습니다.
			 */
			return false;
		}
	}
	
	/*
	 * JwtAuthenticationFilter 에서 사용할 메서드들을 만들어줘야 합니다.
	 * UserId 를 가져오는 코드를 작성해보겠습니다.
	 */
	public String getUserId(String token) {
		log.info(token);
		return Jwts
				.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	/*
	 * JwtAuthenticationFilter 에서 사용할 메서드들을 만들어줘야 합니다.
	 * 인증 정보를 가져오는 코드를 작성해보겠습니다
	 */
	public Authentication getAuthetication(String token) {
		/*
		 * Authentication 은 인터페이스라서 실제로는 객체를 반환해야합니다.
		 * 
		 * UsernamePasswordAuthenticationToken 이라는 객체를 생성해야하는데요.
		 * Principal 을 매개변수로 받습니다. Principal 은 DB로 부터 조회한 결과를 
		 * 담는 객체라고 이해할 수 있습니다. 
		 * 첫 번째, 매개변수로는 ID를 나중에 Principal 을 위해 담아주어야 하는데,
		 * UserDetailsService 를 이용해서, loadUserByUesrname 을 호출하면 됩니다.
		 * loadUserByUsername 의 반환 타입은 UserDetails 를 반환하기 때문에 
		 * UserDetails 타입에 결과를 담아서 첫 번째 매개변수로 이용을 하면 되겠습니다. 
		 * 
		 * 또 다른 매개변수로는 credentials 를 받는데요. credential 은 
		 * 권한을 담게 되는데, userDetails 의 getAuthorities( ) 를 이용하면 되겠습니다.
		 */
		UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));
		return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities());
	}
	
	/*
	 * JwtAuthenticationFilter 에서 사용할 메서드들을 만들어줘야 합니다.
	 * 우선, Request Header 에서 토큰을 꺼내오는 메서드를 작성합니다.
	 */
}























