package com.dfinite.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MovcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex)
    {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(errors ->
        {
            errorList.add(errors.toString());


        });

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
