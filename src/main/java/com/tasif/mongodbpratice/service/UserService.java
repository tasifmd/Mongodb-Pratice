package com.tasif.mongodbpratice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.mongodbpratice.dto.UserDto;
import com.tasif.mongodbpratice.model.User;
import com.tasif.mongodbpratice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

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

}
