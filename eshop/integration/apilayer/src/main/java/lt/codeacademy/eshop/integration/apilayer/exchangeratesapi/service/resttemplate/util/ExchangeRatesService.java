package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.resttemplate.util;

import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;
import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_ENDPOINT_LATEST;

public interface ExchangeRatesService {

  ExchangeRatesDataDto getLatestBaseExchangeRates(String base);
}
