package example.mongod.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String username;

    private String gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User [gender=" + gender + ", id=" + id + ", username=" + username + "]";
    }
    
}
