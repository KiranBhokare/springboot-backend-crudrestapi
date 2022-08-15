package com.backend.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice   //with the help of this 
public class GlobalExceptionHandler 
{
  //handle specific exception
	
	@ExceptionHandler(MycustomException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(MycustomException ex, WebRequest request)
	{
		ErrorInfo errInfo = new ErrorInfo(new Date(),ex.getMessage(),request.getDescription(true));
		
		ResponseEntity<ErrorInfo>  re = new ResponseEntity(errInfo, HttpStatus.NOT_FOUND);
		
		return re;
	}
	
	
 // handle global exception
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorInfo> handleGlobalException(Exception e)
//	{
//		ErrorInfo errInfo1 = new ErrorInfo(new Date() ,e.getMessage() ,"don't worry its just an error...");
//		
//		ResponseEntity<ErrorInfo> re = new ResponseEntity(errInfo1 , HttpStatus.BAD_REQUEST);
//		
//		return re;
//	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(ResourceNotFoundException ex, WebRequest request)
	{
		ErrorInfo errInfo = new ErrorInfo(new Date(),ex.getMessage(),request.getDescription(false));
		
		ResponseEntity<?>  re = new ResponseEntity(errInfo, HttpStatus.BAD_REQUEST);
		
		return re;
	}
	
	
	
	
	
	
}
