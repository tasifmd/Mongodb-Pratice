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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.mongodbpratice.dto.UserDto;
import com.tasif.mongodbpratice.model.User;
import com.tasif.mongodbpratice.model.Vehicle;
import com.tasif.mongodbpratice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		String response = userService.addUser(userDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping
	public List<User> getAllUser() {
		List<User> allUsers = userService.getAllUsers();
		return allUsers;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") String userId) {
		User response = userService.getUser(userId);
		return new ResponseEntity<User>(response, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
		String response = userService.updateUser(userId, userDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
		String response = userService.deleteUser(userId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/addVehicleToUser")
	public ResponseEntity<String> addVehicleToUser(@RequestParam String userId, @RequestParam String vehicleId) {
		String response = userService.addVehicleToUser(userId, vehicleId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/removeVehicleFromUser")
	public ResponseEntity<String> removeVehicleFromUser(@RequestParam String userId, @RequestParam String vehicleId) {
		String response = userService.removeVehicleFromUser(userId, vehicleId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/getVehicleOfUser/{userId}")
	public List<Vehicle> getVehicleOfUser(@PathVariable("userId") String userId) {
		List<Vehicle> response = userService.getVehicleOfUser(userId);
		return response;
	}
}
