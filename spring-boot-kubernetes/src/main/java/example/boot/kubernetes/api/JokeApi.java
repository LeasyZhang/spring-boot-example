package example.boot.kubernetes.api;

import example.boot.kubernetes.model.JokeResponse;
import example.boot.kubernetes.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/joke")
public class JokeApi {

    private JokeService jokeService;

    @Autowired
    public JokeApi(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/{id}")
    public JokeResponse getJokeById(@PathVariable("id") Long id) {
        return jokeService.getJokeById(id);
    }
}
