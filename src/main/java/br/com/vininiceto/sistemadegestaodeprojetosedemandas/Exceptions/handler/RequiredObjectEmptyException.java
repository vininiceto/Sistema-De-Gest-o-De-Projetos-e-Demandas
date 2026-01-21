package br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler;

public class RequiredObjectEmptyException extends RuntimeException {
  public RequiredObjectEmptyException(String message) {
    super(message);
  }
}
