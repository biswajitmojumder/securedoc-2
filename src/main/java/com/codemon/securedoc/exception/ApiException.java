package com.codemon.securedoc.exception;

public class ApiException extends RuntimeException {

    // Constructor
    public ApiException(String message) {
        super(message);
    }

    // Default Constructor
    public ApiException() {
        super("An error occurred while processing your request. Please try again later.");
    }
}
