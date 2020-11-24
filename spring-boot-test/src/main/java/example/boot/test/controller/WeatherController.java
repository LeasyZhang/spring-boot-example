package example.boot.test.controller;

import example.boot.test.entity.Weather;
import example.boot.test.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping(value = "/weather", produces = "application/json")
    public ResponseEntity<Weather> getWeather() {
        List<Weather> weathers = weatherRepository.findAll();
        return ResponseEntity.ok(weathers.get(0));
    }
}
