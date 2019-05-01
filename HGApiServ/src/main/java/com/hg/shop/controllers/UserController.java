package com.hg.shop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hg.shop.entity.UserEntity;
import com.hg.shop.service.UserService;

@RestController
@RequestMapping("/shop")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user) {
		return ResponseEntity.ok().body(userService.saveUser(user));
	}

	@GetMapping("/users")
	public @ResponseBody ResponseEntity<Object> getAllShopUsers() {

		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode createObjectNode = objectMapper.createObjectNode();
		createObjectNode.putPOJO("userList", userService.getAllUsers());
		return ResponseEntity.ok().body(createObjectNode);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "id") Long userId) {
		UserEntity user = userService.getUser(userId);
		if (user == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "id") Long userId) {
		UserEntity user = userService.getUser(userId);
		if (user == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().body(userService.saveUser(user));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserEntity> deleteUser(@PathVariable(value = "id") Long userId) {
		UserEntity user = userService.getUser(userId);
		if (user == null)
			return ResponseEntity.notFound().build();

		userService.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
