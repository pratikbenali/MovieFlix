package io.pratik.Movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8725116493907076179L;

		public MovieNotFoundException(String message) {
			super(message);
		}

		public MovieNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
}
