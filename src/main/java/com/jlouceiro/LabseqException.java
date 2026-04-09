package com.jlouceiro;

import jakarta.ws.rs.BadRequestException;

public class LabseqException extends BadRequestException {

    public LabseqException() {
        super();
    }

    public LabseqException(String message) {
        super(message);
    }
}
