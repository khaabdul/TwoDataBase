package com.MysqlMongo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFound userNotFound) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userNotFound.getMessage());
	}
}
