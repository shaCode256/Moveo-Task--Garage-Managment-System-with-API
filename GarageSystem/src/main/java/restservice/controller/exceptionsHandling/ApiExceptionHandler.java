package restservice.controller.exceptionsHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * exceptions handler class
 */
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestExceptions.class})
    public ResponseEntity<Object> handleApiRequestExceptions(ApiRequestExceptions e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
