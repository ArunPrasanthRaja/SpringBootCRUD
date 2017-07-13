package com.intellect.springbootcud.repository;

/**
 * This exception is thrown when the requested user entry is not found.
 * @author Arun
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}
