package com.tasif.mongodbpratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.mongodbpratice.dto.UserDto;
import com.tasif.mongodbpratice.model.User;
import com.tasif.mongodbpratice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		String response = userService.addUser(userDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping
	List<User> getAllUser() {
		List<User> allUsers = userService.getAllUsers();
		return allUsers;
	}
	
	@PutMapping("/{userId}")
	ResponseEntity<String> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
		String response = userService.updateUser(userId,userDto);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
		String response = userService.deleteUser(userId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
