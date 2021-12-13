/**
 * 
 */
package it.fabrick.exercize.banker.web.rest.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.fabrick.exercize.banker.exception.BankerException;
import it.fabrick.exercize.banker.web.response.ResponseCode;
import it.fabrick.exercize.banker.web.response.impl.ResponseError;

/**
 * @author emiliano.bossi
 */
@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionHandler.class);

    @ExceptionHandler(BankerException.class)
    protected ResponseEntity<ResponseError> handleBankerErrors(BankerException e) {
        ResponseError error = new ResponseError(ResponseCode.INERNAL_ERROR, e);
        ResponseEntity<ResponseError> resp = new ResponseEntity<ResponseError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return resp;
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<ResponseError> handleUncaughtErrors(Throwable e) {
        logger.error(e.getMessage(), e);
        ResponseError error = new ResponseError(ResponseCode.INERNAL_ERROR, e);
        ResponseEntity<ResponseError> resp = new ResponseEntity<ResponseError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        return resp;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseError error = new ResponseError(ResponseCode.VALIDATION_ERROR, ex);
        return new ResponseEntity<Object>(error, status);
    }
}
