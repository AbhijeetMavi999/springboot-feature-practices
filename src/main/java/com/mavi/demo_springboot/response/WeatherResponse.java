package com.mavi.demo_springboot.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    public Location location;
    public Current current;

    public class Current{
        public int temperature;
        @JsonProperty("wind_speed")
        public int windSpeed;
        public int humidity;
        @JsonProperty("is_day")
        public String isDay;
    }

    public class Location{
        public String name;
        public String country;
    }
}
