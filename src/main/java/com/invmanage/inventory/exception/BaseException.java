package com.invmanage.inventory.exception;

import org.springframework.http.ResponseEntity;

public class BaseException extends RuntimeException{

    public BaseException(){

    }


    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.prepareError());
    }

}
