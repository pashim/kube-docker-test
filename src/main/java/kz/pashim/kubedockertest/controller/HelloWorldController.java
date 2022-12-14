package kz.pashim.kubedockertest.controller;

import kz.pashim.kubedockertest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    private UserService userService;

    public HelloWorldController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        System.out.println("hello endpoint was triggered");
        return "Hello world!";
    }

    @GetMapping("/users/add/{name}")
    public void addUser(@PathVariable String name) {
        System.out.println("addUser endpoint was triggered");
        userService.saveUser(name);
    }

    @GetMapping("/users/list")
    public List<String> listUsers() {
        System.out.println("listUsers endpoint was triggered");
        return userService.listUsers();
    }
}
