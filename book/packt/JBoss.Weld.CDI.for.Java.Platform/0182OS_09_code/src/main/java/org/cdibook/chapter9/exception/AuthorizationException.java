package org.cdibook.chapter9.exception;

public class AuthorizationException extends ServiceException {
    public AuthorizationException() {
        super();
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
