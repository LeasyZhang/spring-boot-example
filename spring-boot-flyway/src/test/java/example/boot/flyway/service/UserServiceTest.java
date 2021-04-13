package example.boot.flyway.service;

import example.boot.flyway.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userSerivce;

    @Test
    public void test() {
        userSerivce.deleteAllUsers();

        userSerivce.create("Tom", 10);
        userSerivce.create("Mike", 11);
        userSerivce.create("Didispace", 30);
        userSerivce.create("Oscar", 21);
        userSerivce.create("Linda", 17);

        List<User> userList = userSerivce.getByName("Oscar");
        Assertions.assertEquals(21, userList.get(0).getAge().intValue());

        Assertions.assertEquals(5, userSerivce.getAllUsers());

        userSerivce.deleteByName("Tom");
        userSerivce.deleteByName("Mike");

        Assertions.assertEquals(3, userSerivce.getAllUsers());
    }
}
