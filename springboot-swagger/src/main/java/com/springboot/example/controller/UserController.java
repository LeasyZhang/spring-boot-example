package com.springboot.example.controller;

import com.springboot.example.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {

    private Map<Long, User> userMap;
    private AtomicLong atomicLong;

    @GetMapping("/list")
    public List<User> getUserList() {
        return new ArrayList<>(this.userMap.values());
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        user.setID(atomicLong.incrementAndGet());
        userMap.put(user.getID(), user);
        return user;
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (!userMap.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        userMap.remove(id);
        return ResponseEntity.ok().build();
    }

    @PostConstruct
    public void initMockData() {
        this.userMap = new HashMap<>();
        this.atomicLong = new AtomicLong();

        User mockUser = new User();
        mockUser.setID(atomicLong.incrementAndGet());
        mockUser.setAddress("XiaMen");
        mockUser.setName("Test User");
        mockUser.setAge(25);

        userMap.put(mockUser.getID(), mockUser);
    }
}
