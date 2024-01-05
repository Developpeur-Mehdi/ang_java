package com.mehdi.projet.Service;

import com.mehdi.projet.Config.WeatherConfig;
import com.mehdi.projet.WeatherData;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    private final RestTemplate restTemplate;
    private final WeatherConfig weatherConfig;

    public WeatherService(RestTemplate restTemplate, WeatherConfig weatherConfig) {
        this.restTemplate = restTemplate;
        this.weatherConfig = weatherConfig;
    }

    public WeatherData getWeatherByCity(String city) {
        String url = String.format(BASE_URL, city, weatherConfig.getApiKey());
        ResponseEntity<WeatherData> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherData.class);
        return response.getBody();
    }
}


