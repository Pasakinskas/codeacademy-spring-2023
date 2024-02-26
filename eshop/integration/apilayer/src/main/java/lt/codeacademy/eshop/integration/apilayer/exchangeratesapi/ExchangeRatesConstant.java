package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi;

public final class ExchangeRatesConstant {

  /**
   * NOTE!!!
   * below API and API_KEY are hardcoded and could be (recommended) configured in yml/properties file !!!
   */
  public static final String API = "https://api.apilayer.com/exchangerates_data";
  public static final String API_KEY = "PKpfAK7oVAnEX6KGjZs4MRI8uO9Kj0I2";

  // Endpoints or URI path
  public static final String API_ENDPOINT_LATEST = "/latest";

  // Header names
  public static final String APIKEY_HEADER_NAME = "apikey";
}
