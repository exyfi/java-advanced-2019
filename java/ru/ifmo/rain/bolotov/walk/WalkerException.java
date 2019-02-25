package ru.ifmo.rain.bolotov.walk;

public class WalkerException extends Exception {
    public WalkerException(String message){
        super(message);
    }
    public WalkerException(String message, Throwable cause){
        super(message,cause);
    }
}
