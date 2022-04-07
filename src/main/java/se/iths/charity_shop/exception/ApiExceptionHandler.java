package se.iths.charity_shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResponseEntity<Object> buildResponseEntity(ApiException apiException) {
        return new ResponseEntity<>(apiException, apiException.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        String errorMessage = "Sorry, there was a misspelling in body";
        return buildResponseEntity(new ApiException(HttpStatus.BAD_REQUEST, errorMessage, ex));
    }

    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<Object> idNotFoundException(IdNotFoundException ii) {
        logger.info(ii.getClass().getName());
        String message = "Id not valid";
        return buildResponseEntity(new ApiException(HttpStatus.NOT_FOUND, message, ii));

    }
}
