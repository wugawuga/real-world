package com.example.realWorld.web.user.service;

import org.springframework.stereotype.Service;

import com.example.realWorld.domain.User;
import com.example.realWorld.repository.UserRepository;
import com.example.realWorld.web.user.dto.UserRegistrationDto;
import com.example.realWorld.web.user.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserResponseDto registration(UserRegistrationDto userRegistrationDto) {
		User userEntity = userRepository.save(changeEntity(userRegistrationDto));
		return UserResponseDto.builder()
			.username(userEntity.getUsername())
			.email(userEntity.getEmail())
			.build();
	}

	private User changeEntity(UserRegistrationDto userRegistrationDto) {
		return User.createUser(
			userRegistrationDto.getUsername(),
			userRegistrationDto.getEmail(),
			userRegistrationDto.getPassword()
		);
	}
}
