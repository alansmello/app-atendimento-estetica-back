package com.estetica.atendimento.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.estetica.atendimento.exception.ErrorGeneral;


@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ErrorGeneral.class)
	public ResponseEntity<?> GeneralException(ErrorGeneral exception) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Error", exception.getMessage());
		return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}

}
