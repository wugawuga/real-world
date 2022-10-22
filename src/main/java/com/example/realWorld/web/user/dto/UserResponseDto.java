package com.example.realWorld.web.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserResponseDto {

	private String username;
	private String email;
	private String password;

	@Builder
	public UserResponseDto(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
