package com.example.weatheraggregator.service;

import org.springframework.stereotype.Service;


@Service
public class AggregatorService {


    private final WeatherService weatherService;
    private final TourismService tourismService;

    public AggregatorService(WeatherService weatherService, TourismService tourismService) {
        this.weatherService = weatherService;
        this.tourismService = tourismService;
    }

    public String getAggregatedData() {
        String weatherData = weatherService.getWeatherData();
        String tourismData = tourismService.getTourismData();

        // Kombiniere Wetter und Touristendaten
        String aggregatedData = weatherData.toString() + ", Tourism: " + tourismData;

        return aggregatedData;
    }
}
