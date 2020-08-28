package com.example.boot;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class EchoCommand {

    @ShellMethod(value = "Return input text")
    public String echo(@ShellOption String from) {
        return from;
    }
}
