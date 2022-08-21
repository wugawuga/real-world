package com.example.realWorld.domain;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String username;
	@Column(unique = true)
	private String email;
	private String password;

	@Builder
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public static User createUser(String username, String email, String password) {
		return User.builder()
			.username(username)
			.email(email)
			.password(password)
			.build();
	}
}
