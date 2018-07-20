package com.pluralsight.calcengine;

public class InvalidStatemnetException extends Exception {

    public InvalidStatemnetException(String reason, String statement) {
        super(reason + ": " + statement);
    }

    public InvalidStatemnetException(String reason, String statement, Throwable cause) {
        super(reason + ": " + statement, cause);
    }
}
