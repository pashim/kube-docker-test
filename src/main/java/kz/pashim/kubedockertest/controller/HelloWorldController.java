package kz.pashim.kubedockertest.controller;

import kz.pashim.kubedockertest.service.UserFileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {

    private UserFileServiceImpl userFileServiceImpl;

    public HelloWorldController(UserFileServiceImpl userFileServiceImpl) {
        this.userFileServiceImpl = userFileServiceImpl;
    }

    @GetMapping("/")
    public String hello() {
        log.info("hello endpoint was triggered");
        return "Hello world!";
    }
}
