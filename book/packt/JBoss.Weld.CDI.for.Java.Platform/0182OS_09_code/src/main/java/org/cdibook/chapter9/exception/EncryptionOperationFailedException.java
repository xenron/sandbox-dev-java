package org.cdibook.chapter9.exception;

public class EncryptionOperationFailedException extends RuntimeException {
    public EncryptionOperationFailedException() {
        super();
    }

    public EncryptionOperationFailedException(final String message) {
        super(message);
    }

    public EncryptionOperationFailedException(final Throwable cause) {
        super(cause);
    }
}
