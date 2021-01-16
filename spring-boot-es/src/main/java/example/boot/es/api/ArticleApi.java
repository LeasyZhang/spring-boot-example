package example.boot.es.api;

import example.boot.es.model.Article;
import example.boot.es.model.Author;
import example.boot.es.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/article")
public class ArticleApi {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/{name}")
    public ResponseEntity<List<Article>> getArticlesByName(@PathVariable("name") String name) {
        Page<Article> articles = articleRepository.findByAuthorsName(name, PageRequest.of(0, 10));
        return ResponseEntity.ok(articles.get().collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<String> init() {
        Article article = new Article();
        article.setTitle("Spring Data Elasticsearch");
        article.setAuthors(asList(new Author("John Smith"), new Author("John Doe")));
        articleRepository.save(article);
        return ResponseEntity.ok("Success");
    }
}
