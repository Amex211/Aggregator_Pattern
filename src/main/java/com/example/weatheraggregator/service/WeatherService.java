package com.example.weatheraggregator.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    private final RestTemplate restTemplate;
    private final String apiUrl = "https://api.weatherapi.com/v1/current.json";
    private final String apiKey = "6bf57b49798e47fea48183655232205";

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherData() {
        String url = apiUrl + "?key=" + apiKey + "&q=New%20York";

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Handle error case
            return null;
        }
    }
}

