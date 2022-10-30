package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {

    NetworkException(String message) {
        super("Network error while sending message: " + message);
    }

    NetworkException() {
        this("Network error: no response");
    }

}
