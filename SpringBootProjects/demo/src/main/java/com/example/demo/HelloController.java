package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/")
	public @ResponseBody String index() {
		return "Hello Boot";
	}
	
	// http://localhost:8082/hello?name=JK
	@RequestMapping("/hello")
	public String hello(@RequestParam(required = false) String name, Model model) {
		//@RequestParam 에 String 이라서 default 값을 주지 않아도 된다.
		String greetings = "Hello~" + name;
		model.addAttribute("greetings", greetings);
		return "hello"; //WEB-INF/views/hello.jsp
	}
}
