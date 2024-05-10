package com.anudip.training.exception;

public class UserIdNotFoundException extends RuntimeException{

	public UserIdNotFoundException(String message) {
        super(message);
    }
}