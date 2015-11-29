package com.tiandy.demo.chats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorld {

	@RequestMapping("/lala")
	public String test(){
		System.out.println("lalalal");
		return "index";
	}
}
