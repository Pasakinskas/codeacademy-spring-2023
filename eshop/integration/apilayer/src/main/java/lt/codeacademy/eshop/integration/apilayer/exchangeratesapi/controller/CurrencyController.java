package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesDataDto;
import lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("integration")
@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

  private final ExchangeRatesService exchangeRatesService;

  @GetMapping
  public ExchangeRatesDataDto getCurrencies() {
    return exchangeRatesService.getLatestBaseExchangeRates("EUR");
  }
}
