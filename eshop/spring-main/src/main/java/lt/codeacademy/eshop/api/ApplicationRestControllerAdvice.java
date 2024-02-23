package lt.codeacademy.eshop.api;

import lt.codeacademy.eshop.common.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

  @ExceptionHandler
  public ErrorResponseDto serverError(Exception e) {
    return ErrorResponseDto.builder()
      .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
      .errorMessage(e.getMessage())
      .build();
  }
}
