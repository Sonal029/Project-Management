package com.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<MyError> exception1(ProjectException se , WebRequest req)
	{
		MyError me = new MyError();
		me.setTimeStamp(LocalDateTime.now());
		me.setDetails(se.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> exception2(NoHandlerFoundException se , WebRequest req)
	{
		MyError me = new MyError();
		me.setTimeStamp(LocalDateTime.now());
		me.setDetails(se.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exception3(Exception se , WebRequest req)
	{
		MyError me = new MyError();
		me.setTimeStamp(LocalDateTime.now());
		me.setDetails(se.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> exception3(MethodArgumentNotValidException se , WebRequest req)
	{
		MyError me = new MyError();
		me.setTimeStamp(LocalDateTime.now());
		me.setDetails(se.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
