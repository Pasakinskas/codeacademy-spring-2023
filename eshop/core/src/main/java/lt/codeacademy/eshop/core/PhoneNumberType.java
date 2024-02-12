package lt.codeacademy.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PhoneNumberType {
  GLOBAL("+370"),
  LOCAL("86");

  private final String prefixCode;
}
