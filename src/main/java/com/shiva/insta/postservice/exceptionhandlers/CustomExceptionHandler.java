package com.shiva.insta.postservice.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shiva.insta.postservice.exceptions.ResourceNotFoundException;
import com.shiva.insta.postservice.models.ExceptionResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ExceptionResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND.toString(), 
        								exception.getMessage(),
        								"");
    }
	
}
