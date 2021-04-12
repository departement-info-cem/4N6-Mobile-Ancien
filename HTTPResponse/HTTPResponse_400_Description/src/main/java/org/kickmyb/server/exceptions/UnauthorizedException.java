package org.kickmyb.server.exceptions;

public class UnauthorizedException extends Exception{
    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
