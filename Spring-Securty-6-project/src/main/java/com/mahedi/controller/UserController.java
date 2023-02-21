package com.mahedi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahedi.entity.User;
import com.mahedi.service.UserService;

@RestController
//@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/saveuser")
	public User saveusers(@RequestBody User user) {
		return userService.saveusers(user);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/allUser")
	public List<User> getUserAll(){
		return userService.getUserAll();
	}
	
	@GetMapping("/dashboard")
    public String register(){
        return "this is dashboard page";
    }
	
//	@GetMapping("/{username}")
//    public User getUser(@PathVariable("username") String username){
//    return userService.getUser(username);
//    }
	
	
}
