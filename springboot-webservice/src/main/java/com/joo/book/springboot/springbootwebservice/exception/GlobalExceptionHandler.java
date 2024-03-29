package com.joo.book.springboot.springbootwebservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseError handleIllegalArguException(IllegalArgumentException e) {

//		return new ResponseEntity<>(
//				new ResponseError().setDetails(e.getLocalizedMessage()).setTimestamp(LocalDateTime.now()),
//				HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseError().setDetails(e.getLocalizedMessage()).setTimestamp(LocalDateTime.now());
	}
}
