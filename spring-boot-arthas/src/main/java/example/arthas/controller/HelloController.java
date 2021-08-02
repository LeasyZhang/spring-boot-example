package example.arthas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("{word}")
    public ResponseEntity<String> hi(@PathVariable(name = "word") String word) {
        String response = "hello" + word;
        return ResponseEntity.ok(response);
    }
}
