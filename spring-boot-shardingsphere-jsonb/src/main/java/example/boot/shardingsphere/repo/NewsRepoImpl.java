package example.boot.shardingsphere.repo;

import example.boot.shardingsphere.model.News;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class NewsRepoImpl implements NewsRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public News saveOne(final News news) {
        Session session = entityManager.unwrap(Session.class);
        return session.doReturningWork(connection -> {
            String sql = "insert into news(title, author, content) values (?, ?, ?::jsonb)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int paramIndex = 1;
            ps.setString(paramIndex++, news.getTitle());
            ps.setString(paramIndex++, news.getAuthor());
            ps.setString(paramIndex, news.getContent());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            while (result.next()) {
                news.setId(result.getLong(1));
            }
            ps.close();
            return news;
        });
    }
}
