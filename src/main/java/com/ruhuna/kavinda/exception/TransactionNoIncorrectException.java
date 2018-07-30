package com.ruhuna.kavinda.exception;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/30/2018
 */
public class TransactionNoIncorrectException extends RuntimeException{
    public TransactionNoIncorrectException() {
    }

    public TransactionNoIncorrectException(String message) {
        super(message);
    }

    public TransactionNoIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }
}
