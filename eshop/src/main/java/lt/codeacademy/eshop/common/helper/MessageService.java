package lt.codeacademy.eshop.common.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * This service component used only for message translating inside java
 */
@Component
@RequiredArgsConstructor
@Log4j2
public class MessageService {

  private final MessageSource messageSource;

  public String getTranslatedMessage(String key) {
    try {
      return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {
      if (key != null && !key.equals("")) {
        log.error("Key " + key + " does not exist!");

        return String.format("?%s?", key);
      }
    }

    return "";
  }
}
