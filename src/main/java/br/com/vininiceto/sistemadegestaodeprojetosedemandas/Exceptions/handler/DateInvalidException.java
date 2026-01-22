package br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler;

public class DateInvalidException extends RuntimeException {
    public DateInvalidException(String message) {
        super(message);
    }
}
