package example.spring.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.spring.boot.model.Content;
import example.spring.boot.model.News;
import example.spring.boot.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsRepo newsRepo;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public NewsController(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(newsRepo.findById(id).orElse(new News()));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNews() {
        Content content = Content.builder()
                .createTime(Instant.now())
                .subTitle("Hello news")
                .inner("News content send by Joe")
                .build();
        News news = News.builder()
                .author("Joe Zhang")
                .title("Main title")
                .content(mapper.valueToTree(content))
                .build();
        newsRepo.save(news);
        return ResponseEntity.ok("Save success");
    }
}
