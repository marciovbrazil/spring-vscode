package com.marcio.springvscode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String getMethodName() {
        return "Ola Mundo VSCode";
    }

}
