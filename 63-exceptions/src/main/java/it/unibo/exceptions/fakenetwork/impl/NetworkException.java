package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {
    private String message;

    NetworkException(String message) {
        this.message = "Network error while sending message: " + message;
    }

    NetworkException() {
        this.message = "Netwrok error: no response";
    }

    public String toString() {
        return this.message;
    }
}
