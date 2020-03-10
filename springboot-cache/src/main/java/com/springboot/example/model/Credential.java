package com.springboot.example.model;

public class Credential {

    public Credential(String type, String username, String credential) {
        this.type = type;
        this.username = username;
        this.credential = credential;
    }

    String type;
    String username;
    String credential;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "type='" + type + '\'' +
                ", username='" + username + '\'' +
                ", credential='" + credential + '\'' +
                '}';
    }
}
