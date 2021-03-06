package io.pratik.Movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 4636562976668055338L;

	public UserAlreadyExistsException(String message){
		super(message);
	}
			
	public UserAlreadyExistsException(String message, Throwable cause){
		super(message, cause);
	}
			

}
