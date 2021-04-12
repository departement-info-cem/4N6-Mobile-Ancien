package org.kickmyb.server.exceptions;

public class WrongValueException extends Exception{
    public WrongValueException(String errorMessage) {
        super(errorMessage);
    }
}
