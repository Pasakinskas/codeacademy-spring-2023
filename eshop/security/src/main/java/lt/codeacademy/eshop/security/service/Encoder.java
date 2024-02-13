package lt.codeacademy.eshop.security.service;

public interface Encoder {

  String encode(CharSequence rawPassword);
}
