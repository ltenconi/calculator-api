package com.work.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class GlobalErrorController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public ResponseEntity<Object> error(HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
