package com.example.myapp.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.myapp.common.filter.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.KOREAN);
		return slr;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("i18n/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Bean //이 빈을 addInterceptor 를 이용해서 지정을 합니다.
	public LoginInterceptor loginInterceptor() { 
		return new LoginInterceptor();
	}
	
	@Override //WebMvcConfigurer 에 정의되어 있는 addInterceptors 메서드를 사용합니다.
	public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(loginInterceptor()) //addInterceptor 를 한 다음에, 
				.addPathPatterns("/file/**") //url 을 지정해주면 됩니다. 
				.addPathPatterns("/board/write/**")
				.addPathPatterns("/board/update/**")
				.addPathPatterns("/board/reply/**")
				.addPathPatterns("/board/delete/**");
	}

}
