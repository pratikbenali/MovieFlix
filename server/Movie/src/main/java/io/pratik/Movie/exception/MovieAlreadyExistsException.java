package io.pratik.Movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class MovieAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 2897433386846222255L;

	public MovieAlreadyExistsException(String message){
		super(message);
	}
			
	public MovieAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}
}