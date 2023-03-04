package org.kickmyb.server.exceptions;

public class UnhandledException extends Exception{
    public UnhandledException(String errorMessage) {
        super(errorMessage);
    }
}
