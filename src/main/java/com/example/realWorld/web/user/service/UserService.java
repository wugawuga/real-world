package com.example.realWorld.web.user.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.realWorld.domain.User;
import com.example.realWorld.repository.UserRepository;
import com.example.realWorld.web.user.dto.UserRegistrationDto;
import com.example.realWorld.web.user.dto.UserResponseDto;
import com.example.realWorld.web.user.dto.UserUpdateDto;

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

	@Transactional
	public UserResponseDto update(UserUpdateDto userUpdateDto) {
		System.out.println("userUpdateDto.getEmail() = " + userUpdateDto.getEmail());
		System.out.println("userUpdateDto.getBio() = " + userUpdateDto.getBio());
		User userEntity = userRepository.findByEmail(userUpdateDto.getEmail())
			.orElseThrow(() -> new NoSuchElementException("잘못된 이메일 입니다"));

		userEntity.update(userUpdateDto);

		System.out.println("userEntity.getBio() = " + userEntity.getBio());
		System.out.println("userEntity.getEmail() = " + userEntity.getEmail());

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
