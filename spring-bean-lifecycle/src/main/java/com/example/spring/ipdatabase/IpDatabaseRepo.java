package com.example.spring.ipdatabase;

public class IpDatabaseRepo {

    private String file;

    public IpDatabaseRepo(String file) {
        this.file = file;
    }

    public String lookup(String ipAddress) {
        return "CN";
    }
}
