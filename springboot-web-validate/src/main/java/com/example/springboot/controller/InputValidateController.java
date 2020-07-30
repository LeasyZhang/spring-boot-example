package com.example.springboot.controller;

import com.example.springboot.response.RestResponse;
import com.example.springboot.validate.InputValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class InputValidateController {

    @PostMapping("/input")
    public RestResponse input(@Valid @RequestBody Input input) {
        return new RestResponse(HttpStatus.OK.toString(), input.getInput());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponse handleConstraintException(MethodArgumentNotValidException e) {
        RestResponse restResponse = new RestResponse();
        restResponse.setCode(HttpStatus.BAD_REQUEST.toString());
        restResponse.setMessage("Invalid " + e.getBindingResult().getFieldError().getField());
        return restResponse;
    }

    private static class Input {
        @InputValidator
        String input;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }
    }
}
