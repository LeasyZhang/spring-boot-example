package example.boot.actuator.controller;

import example.boot.actuator.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieAPI {
    
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> listMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(Movie.builder()
                .director("Joe")
                .imageUrl("https://movieimage.com")
                .title("Mirror")
                .type("Adventure")
                .url("https://movie.mirror.com")
                .build());
        return ResponseEntity.ok(movies);
    }
}
