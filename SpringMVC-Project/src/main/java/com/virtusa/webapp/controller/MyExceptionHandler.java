package com.virtusa.webapp.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = EntityNotFoundException.class)
	public String entityException(Model m) {
		return "errpage";
	}
}
