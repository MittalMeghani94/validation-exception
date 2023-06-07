package com.demo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.dto.UserRequest;
import com.demo.api.entity.User;
import com.demo.api.exception.UserNotFoundException;
import com.demo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest) {

		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<User> getById(@PathVariable int id) throws UserNotFoundException {
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent())
			return ResponseEntity.ok(user.get());
		else
			throw new UserNotFoundException("user not found with id "+id);
		
	}

}
