package com.tiket.tix.project.libraries.exception;

public class BusinessLogicException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String code;
  private final String message;

  public BusinessLogicException(String code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "BusinessLogicException{" +
        "code='" + code + '\'' +
        "} " + super.toString();
  }
}
