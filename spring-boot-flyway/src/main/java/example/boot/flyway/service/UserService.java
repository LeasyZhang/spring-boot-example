package example.boot.flyway.service;

import example.boot.flyway.model.User;

import java.util.List;

public interface UserService {

    int create(String name, Integer age);

    List<User> getByName(String name);

    int deleteByName(String name);

    int getAllUsers();

    int deleteAllUsers();
}
