package lt.codeacademy.eshop.integration.apilayer.exchangeratesapi.dto;

import java.util.Map;

/**
 * {
 *   "base": "USD",
 *   "date": "2021-03-17",
 *   "rates": {
 *     "EUR": 0.813399,
 *     "GBP": 0.72007,
 *     "JPY": 107.346001
 *   },
 *   "success": true,
 *   "timestamp": 1519296206
 * }
 */
public record ExchangeRatesDataDto(
  String base,
  String date,
  Map<String, Double> rates,
  boolean success,
  long timestamp
) {
}
