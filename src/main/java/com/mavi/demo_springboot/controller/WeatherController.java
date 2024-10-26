package com.mavi.demo_springboot.controller;

import com.mavi.demo_springboot.response.WeatherResponse;
import com.mavi.demo_springboot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public ResponseEntity<WeatherResponse> getWeatherDetails() {
        WeatherResponse weatherResponse = weatherService.getWeather("Meerut");
        return new ResponseEntity<>(weatherResponse, HttpStatus.OK);
    }
}
