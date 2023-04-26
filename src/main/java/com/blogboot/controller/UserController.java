package com.blogboot.controller;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogboot.model.User;
import com.blogboot.repository.UserRepository;
import com.blogboot.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@RestController
@RequestMapping("api")
public class UserController {
	UserRepository userRepository;
	private UsersService usersService = new UsersService();

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/home")
	public String home() {
		return "Welocome!";
	}

	@PostMapping("/users")
	public String createnewuser(@RequestBody User user) {
		System.out.println("User name::::" + user.getLastname());
		usersService.saveRegistrationData(user);
		return "Data Added";
	}

	@GetMapping("/users")
	public List<User> getUser() {
		return usersService.getGroceryRecord();
	}
	
	@GetMapping("/users/{empid}")
	public User getUserID(@PathVariable("empid") int id) {
		return usersService.getGroceryRecordByID(id);
	}
	
	@DeleteMapping("/users/{empid}")
	public String deleteUserId(@PathVariable int empid) {
		usersService.deleteById(empid);
		return "Employee Deleted Successfully";
	}
	
	@PutMapping("/users/{empid}")
	public String updateEmployeeById(@PathVariable("empid") int empid, @RequestBody User user) {
		usersService.updateGroceryData(empid, user);
		return "Data Updated";
	}
}
