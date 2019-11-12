package com.springboot.example.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private String content;

    private Date timeStamp;

    public Order() {

    }

    public Order(String content, Date timeStamp) {
        this.content = content;
        this.timeStamp = timeStamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
