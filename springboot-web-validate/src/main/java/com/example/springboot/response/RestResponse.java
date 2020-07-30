package com.example.springboot.response;

import java.io.Serializable;

public final class RestResponse implements Serializable {
    private String code;
    private String message;

    public RestResponse() {

    }

    public RestResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
