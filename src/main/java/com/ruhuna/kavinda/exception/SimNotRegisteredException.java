package com.ruhuna.kavinda.exception;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class SimNotRegisteredException extends RuntimeException {
    public SimNotRegisteredException() {
    }

    public SimNotRegisteredException(String message) {
        super(message);
    }

    public SimNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

}
