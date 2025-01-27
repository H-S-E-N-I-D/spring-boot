package com.shdinesh.springcrud.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
