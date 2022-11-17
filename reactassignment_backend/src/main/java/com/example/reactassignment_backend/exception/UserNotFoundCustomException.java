package com.example.reactassignment_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundCustomException extends RuntimeException{
    public UserNotFoundCustomException(String userName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", userName, fieldName, fieldValue));
        this.userName = userName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getUserName() {
        return userName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    @Serial
    private static final long serialVersionUID = 1L;
    private String userName;
    private String fieldName;
    private Object fieldValue;

}
