package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.resttemplate.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RestTemplateUtil {

  public static <T> T callGet(final RestTemplate restTemplate,
                              final String url,
                              final Class<T> responseDto,
                              final HttpHeaders requestHttpHeaders) {
    log.atDebug().log("====> RestTemplate call GET: {}", url);
    return restTemplate.exchange(
      url,
      HttpMethod.GET,
      new HttpEntity<>(null, requestHttpHeaders),
      responseDto
    ).getBody();
  }
}
