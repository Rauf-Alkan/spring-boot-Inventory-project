package com.invmanage.inventory.handler;


import com.invmanage.inventory.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.management.BadAttributeValueExpException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExcaptionHandler {


    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(request, exception.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult().getFieldErrors().stream().
                map(error -> error.getField() +": "+ error.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    private String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public<E> ApiError<E> createApiError(WebRequest request, E message){
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);
        apiError.setException(exception);

        return apiError;
    }
}
