package example.boot.shardingsphere.api;

import com.google.gson.Gson;
import example.boot.shardingsphere.model.Content;
import example.boot.shardingsphere.model.News;
import example.boot.shardingsphere.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsRepo newsRepo;

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
                .content(new Gson().toJson(content))
                .build();
        newsRepo.saveOne(news);
        return ResponseEntity.ok("Save success");
    }
}
