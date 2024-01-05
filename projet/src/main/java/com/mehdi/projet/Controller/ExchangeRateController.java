package com.mehdi.projet.Controller;

import com.mehdi.projet.Service.ExchangeRateResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExchangeRateController {

    private static final String EXCHANGE_RATE_API_KEY = "b4306502ded2cd9a4567e2bb";
    private static final String EXCHANGE_RATE_API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    @GetMapping("/exchange-rate/{baseCurrency}/{targetCurrency}")
    public ExchangeRateResponse getExchangeRate(@PathVariable String baseCurrency, @PathVariable String targetCurrency) {
        String apiUrl = String.format("%s%s/pair/%s/%s", EXCHANGE_RATE_API_BASE_URL, EXCHANGE_RATE_API_KEY, baseCurrency, targetCurrency);
        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);
        ExchangeRateResponse response = restTemplate.getForObject(apiUrl, ExchangeRateResponse.class);

        if (response.getResult().equals("success")) {
            return response;
        } else {
            // Gérer les cas d'erreur si nécessaire
            return null;
        }
    }
}
