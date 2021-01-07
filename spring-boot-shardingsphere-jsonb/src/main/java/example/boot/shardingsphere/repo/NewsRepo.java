package example.boot.shardingsphere.repo;

import example.boot.shardingsphere.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepo extends JpaRepository<News, Long>, NewsRepoCustom {
}
