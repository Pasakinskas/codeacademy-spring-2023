package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.webclient.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API;
import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_ENDPOINT_LATEST;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebClientUtil {

  public static <T> T callGet(final String baseUrl,
                              final String uriPath,
                              final Class<T> responseDto,
                              final HttpHeaders requestHttpHeaders) {
    log.atDebug().log("====> WebClient call GET: {}", baseUrl.concat(uriPath));

    return WebClient.builder()
      .baseUrl(baseUrl)
      .defaultHeaders(httpHeaders -> httpHeaders.addAll(requestHttpHeaders))
      .build()
      .get()
      .uri(uriPath)
      .retrieve()
      .bodyToMono(responseDto)
      .log()
      .block();
  }
}
