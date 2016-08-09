package com.baselogic.javaee6.jmx;

import java.rmi.*;

public class JINIConnectorException extends RemoteException {
    private Exception exception = null;

    public JINIConnectorException(String message, Exception ex) {
        super(message, ex);
        this.exception = ex;
    }

    public Exception getWrappedException() {
        return exception;
    }

}

