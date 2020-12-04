package example.mongod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import example.mongod.model.User;
import example.mongod.repo.UserRepository;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = userRepository.findAll();
        users.stream().forEach(System.out::println);
    }
    
}
