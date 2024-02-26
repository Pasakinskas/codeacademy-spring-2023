package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service;

import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;
import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_ENDPOINT_LATEST;

public interface ExchangeRatesService {

  ExchangeRatesDataDto getLatestBaseExchangeRates(String base);

  default HttpHeaders getDefaultHeaders() {
    HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(APIKEY_HEADER_NAME, API_KEY);

    return requestHttpHeaders;
  }
}
