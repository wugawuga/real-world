package com.example.realWorld.web.user.dto;

import lombok.Data;

@Data
public class UserUpdateDto extends UserRequestDto {

	private String bio;
	private String image;

}
