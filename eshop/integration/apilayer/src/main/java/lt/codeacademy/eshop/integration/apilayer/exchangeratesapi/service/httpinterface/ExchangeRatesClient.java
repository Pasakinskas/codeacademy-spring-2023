package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import lombok.Getter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Getter
public class ExchangeRatesClient {

  private final ExchangeRatesHttpInterfaceService exchangeRatesService;

  public ExchangeRatesClient(WebClient webClient) {
    final HttpServiceProxyFactory httpServiceProxyFactory =
      HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

    exchangeRatesService = httpServiceProxyFactory.createClient(ExchangeRatesHttpInterfaceService.class);
  }
}
