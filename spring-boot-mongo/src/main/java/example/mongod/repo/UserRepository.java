package example.mongod.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import example.mongod.model.User;

public interface UserRepository extends MongoRepository<User, String>{

    
    
}
