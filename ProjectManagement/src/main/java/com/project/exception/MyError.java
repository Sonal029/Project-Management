package com.project.exception;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyError {

	private String details;
	private String description;
	private LocalDateTime timeStamp;
	
}
