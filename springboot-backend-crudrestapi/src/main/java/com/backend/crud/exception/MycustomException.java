package com.backend.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MycustomException extends RuntimeException{

	String msg;
	
	public  MycustomException(String msg)
	{
		super(msg);
		
		this.msg = msg;
		
	}
}
