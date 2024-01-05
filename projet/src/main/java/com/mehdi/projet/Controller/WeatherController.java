package com.mehdi.projet.Controller;

import com.mehdi.projet.Service.WeatherService;
import com.mehdi.projet.WeatherData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherData> getWeatherByCity(@RequestParam String city) {
        WeatherData weatherData = weatherService.getWeatherByCity(city);
        if (weatherData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(weatherData);
    }
}

