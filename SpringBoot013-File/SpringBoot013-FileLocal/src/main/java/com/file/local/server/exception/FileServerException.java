package com.file.local.server.exception;

public class FileServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public FileServerException(String message) {
        super(message);
    }

    public FileServerException(Exception e) {
        super(e);
    }
}
