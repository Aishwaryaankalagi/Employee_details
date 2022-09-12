package exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	// handling specific exception
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request){
			ApiError ApiError = 
					new ApiError(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(ApiError, HttpStatus.NOT_FOUND);
		}

		// handling global exception
	
	}