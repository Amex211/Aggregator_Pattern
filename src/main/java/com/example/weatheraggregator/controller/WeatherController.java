package com.example.weatheraggregator.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatheraggregator.service.AggregatorService;
import com.example.weatheraggregator.service.WeatherService;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final AggregatorService aggregatorService;

    public WeatherController(WeatherService weatherService, AggregatorService aggregatorService) {
        this.weatherService = weatherService;
        this.aggregatorService = aggregatorService;
    }

    @GetMapping
    public String getWeather() {
        String weatherData = weatherService.getWeatherData();
        String aggregatedData = aggregatorService.getAggregatedData();

        // Kombiniere Wetter und touristen Daten
        String result = "Weather: " + weatherData.toString() + ", Aggregated Data: " + aggregatedData;

        return result;
    }
}