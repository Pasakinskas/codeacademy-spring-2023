package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.webclient.util.WebClientUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API;

@Profile("integration & reactive-exchange-interface")
@Service
@Slf4j
public class ExchangeRatesClientService implements ExchangeRatesService {

  private final ExchangeRatesClient exchangeRatesClient =
    new ExchangeRatesClient(WebClientUtil.buildWebClientOf(API, getDefaultHeaders()));

  @Override
  public ExchangeRatesDataDto getLatestBaseExchangeRates(String base) {
    log.atDebug().log("====> Exchange http interface call GET: {}", API);
    return exchangeRatesClient.getExchangeRatesService().getLatest(base, null);
  }
}
