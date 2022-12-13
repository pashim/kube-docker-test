package kz.pashim.kubedockertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        System.out.println("hello world endpoint was triggered");
        return "Hello world!";
    }
}
