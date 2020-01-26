package com.dxc.ClientServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dxc.ClientServices.entity.ClientErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ClientErrorResponse> handleException(ClientNotFoundException ex){
		
		ClientErrorResponse error=new ClientErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ClientErrorResponse> handleException(MethodArgumentNotValidException ex){
		
		ClientErrorResponse error=new ClientErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ClientErrorResponse> handleException(MethodArgumentTypeMismatchException ex){
		
		ClientErrorResponse error=new ClientErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ClientErrorResponse> handleAllException(Exception ex){
		
		ClientErrorResponse error=new ClientErrorResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
