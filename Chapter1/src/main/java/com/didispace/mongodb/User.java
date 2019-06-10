package com.didispace.mongodb;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
	@Id
	private Long id;

	private String username;
	private Integer age;
}
