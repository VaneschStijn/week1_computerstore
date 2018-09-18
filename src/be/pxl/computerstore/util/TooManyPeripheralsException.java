package be.pxl.computerstore.util;

import java.util.TooManyListenersException;

public class TooManyPeripheralsException extends Exception{
    public TooManyPeripheralsException(String message) {
        super(message);
    }
}
