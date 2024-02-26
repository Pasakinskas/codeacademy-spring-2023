package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import static lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_ENDPOINT_LATEST;

public interface ExchangeRatesHttpInterfaceService {

  @GetExchange(API_ENDPOINT_LATEST)
  ExchangeRatesDataDto getLatest(@RequestParam(required = false) String base,
                                 @RequestParam(required = false) String symbols);
}
