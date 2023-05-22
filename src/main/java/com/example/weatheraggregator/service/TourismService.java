package com.example.weatheraggregator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TourismService {

    private final RestTemplate restTemplate;

    public TourismService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTourismData() {
        String apiUrl = "http://api.opentripmap.com/0.1/ru/places/xid/Q372040";
        String apiKey = "5ae2e3f221c38a28845f05b676aeffe366f70486041935ad110789d2";
    
        // Führe eine HTTP-Anfrage an die API aus
        String response = restTemplate.getForObject(apiUrl + "?apikey=" + apiKey, String.class);
    
        // Verarbeite die erhaltenen Daten und gib sie zurück
        return response;
    }
}