package example.jooq.service;

import example.jooq.databases.tables.pojos.Author;
import example.jooq.model.AuthorModel;
import example.jooq.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public Author save(AuthorModel authorModel) {
        Integer id = authorRepo.insert(authorModel);

        return getOneById(id);
    }

    public Author edit(AuthorModel authorModel) {
        authorRepo.update(authorModel);

        return getOneById(authorModel.getId());
    }

    public Author remove(Integer id) {
        authorRepo.delete(id);

        return getOneById(id);
    }

    public List<Author> getAll() {
        return authorRepo.selectAll();
    }

    public Author getOneById(Integer id) {
        return authorRepo.selectOneById(id);
    }
}
