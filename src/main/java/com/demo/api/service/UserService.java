package com.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.dto.UserRequest;
import com.demo.api.entity.User;
import com.demo.api.exception.UserNotFoundException;
import com.demo.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		
		User user = new User(userRequest.getName(),userRequest.getEmail(),
				userRequest.getMobile(),userRequest.getAge(),
				userRequest.getGender(),userRequest.getNationality());
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(int id) throws UserNotFoundException {
		
		
		return userRepository.findById(id);
		
	}
}
