package com.tasif.mongodbpratice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.mongodbpratice.dto.UserDto;
import com.tasif.mongodbpratice.model.User;
import com.tasif.mongodbpratice.model.Vehicle;
import com.tasif.mongodbpratice.repository.UserRepository;
import com.tasif.mongodbpratice.repository.VehicleRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VehicleRepository vehicleRepository;

	public String addUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);
		return "User added successfully";
	}

	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	public String updateUser(String userId, UserDto userDto) {
		User user = userRepository.findById(userId).get();
		user.setUserName(userDto.getUserName());
		user.setUserEmail(userDto.getUserEmail());
		user.setMobileNumber(userDto.getMobileNumber());
		userRepository.save(user);
		return "User is successfully updated";
	}

	public String deleteUser(String userId) {
		User user = userRepository.findById(userId).get();
		userRepository.delete(user);
		return "User is successfully deleted";
	}

	public User getUser(String userId) {
		User user = userRepository.findById(userId).get();
		return user;
	}

	public String addVehicleToUser(String userId, String vehicleId) {
		User user = userRepository.findById(userId).get();
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		if (user.getVehicles().contains(vehicle))
			return "Vehicle has already exist in this user";
		user.getVehicles().add(vehicle);
		userRepository.save(user);
		return "Vehicle has been added to the user";
	}

	public String removeVehicleFromUser(String userId, String vehicleId) {
		User user = userRepository.findById(userId).get();
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		if (!user.getVehicles().contains(vehicle))
			return "No such vehicle exist in this user";
		user.getVehicles().remove(vehicle);
		userRepository.save(user);
		return "Vehicle has been removed from the user";
	}

	public List<Vehicle> getVehicleOfUser(String userId) {
		User user = userRepository.findById(userId).get();
		List<Vehicle> vehicles = user.getVehicles();
		return vehicles;
	}

}
