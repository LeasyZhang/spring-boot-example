package example.boot.shardingsphere.repo;

import example.boot.shardingsphere.model.News;

public interface NewsRepoCustom {
    News saveOne(News news);
}
