package com.example.realWorld.web.user.dto;

import lombok.Data;

@Data
public class UserRegistrationDto extends UserRequestDto{

	private String username;
	private String password;

}
