package br.com.mendes.nextlevelprojeto.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mendes.nextlevelprojeto.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)	
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest httpRequest) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(
				Instant.now(), 
				status.value(), 
				"Objeto não encontrado!", 
				ex.getMessage(), 
				httpRequest.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
