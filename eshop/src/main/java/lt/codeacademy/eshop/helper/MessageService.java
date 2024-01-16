package lt.codeacademy.eshop.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * This service component used only for message translating inside java
 */
@Component
@RequiredArgsConstructor
public class MessageService {

  private final MessageSource messageSource;

  public String getTranslatedMessage(String key) {
    return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
  }
}
