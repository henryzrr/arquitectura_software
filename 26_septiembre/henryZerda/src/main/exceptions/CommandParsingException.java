package main.exceptions;

public class CommandParsingException extends Exception {
    public CommandParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
