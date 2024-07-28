package com.fitsync.FitSync.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class ExerciseTemplateCustomException extends RuntimeException {
  private String errorCode;

  public ExerciseTemplateCustomException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
