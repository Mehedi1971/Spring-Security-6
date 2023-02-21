package com.mahedi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PagesController {
	 @GetMapping("/home")
	    public String home(){
	        return "this is home page";
	    }
	    @GetMapping("/register")
	    public String register(){
	        return "this is register page";
	    }
}
