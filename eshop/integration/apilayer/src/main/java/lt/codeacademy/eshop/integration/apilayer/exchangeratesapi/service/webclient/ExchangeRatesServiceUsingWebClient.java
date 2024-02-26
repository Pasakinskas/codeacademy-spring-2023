package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.webclient;

import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.webclient.util.WebClientUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;

@Profile("integration & reactive-exchange")
@Service
public class ExchangeRatesServiceUsingWebClient implements ExchangeRatesService {
  @Override
  public ExchangeRatesDataDto getLatestBaseExchangeRates(String base) {
    return WebClientUtil.callGet(
      API,
      API_ENDPOINT_LATEST.concat("?base=".concat(base)),
      ExchangeRatesDataDto.class,
      getDefaultHeaders());
  }
}
