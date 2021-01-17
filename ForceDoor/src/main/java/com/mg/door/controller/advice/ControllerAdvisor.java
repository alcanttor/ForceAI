package com.mg.door.controller.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mg.door.exceptions.CreationFailureException;
import com.mg.door.exceptions.DeletionFailureException;
import com.mg.door.exceptions.NoElementFoundException;
import com.mg.door.exceptions.SiteLimitConsumedException;
import com.mg.door.exceptions.UpdationFailureException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoElementFoundException.class)
	public ResponseEntity<Object> handleNodataFoundException(

			NoElementFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UpdationFailureException.class)
	public ResponseEntity<Object> handleUpdationFailureException(

			UpdationFailureException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CreationFailureException.class)
	public ResponseEntity<Object> handleCreationFailureException(

			CreationFailureException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DeletionFailureException.class)
	public ResponseEntity<Object> handleDeletionFailureException(

			DeletionFailureException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SiteLimitConsumedException.class)
	public ResponseEntity<Object> handleSiteLimitConsumedException(

			SiteLimitConsumedException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
