package com.example.realWorld.web.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.realWorld.web.user.dto.UserRegistrationDto;
import com.example.realWorld.web.user.dto.UserResponseDto;
import com.example.realWorld.web.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/api/users")
	public ResponseEntity<UserResponseDto> registration(@RequestBody UserRegistrationDto userRegistrationDto) {
		UserResponseDto registrationDto = userService.registration(userRegistrationDto);
		return new ResponseEntity<>(registrationDto, HttpStatus.OK);
	}
}
