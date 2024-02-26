package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.resttemplate;

import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.resttemplate.util.ExchangeRatesService;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.resttemplate.util.RestTemplateUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;
import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_ENDPOINT_LATEST;

@Service
public class ExchangeRatesServiceUsingRestTemplate implements ExchangeRatesService {
  @Override
  public ExchangeRatesDataDto getLatestBaseExchangeRates(String base) {
    HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(APIKEY_HEADER_NAME, API_KEY);

    return RestTemplateUtil.callGet(
      new RestTemplate(),
      API.concat(API_ENDPOINT_LATEST).concat("?base=".concat(base)),
      ExchangeRatesDataDto.class,
      requestHttpHeaders);
  }
}
