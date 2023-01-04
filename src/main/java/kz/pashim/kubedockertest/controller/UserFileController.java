package kz.pashim.kubedockertest.controller;

import kz.pashim.kubedockertest.dto.UserDTO;
import kz.pashim.kubedockertest.service.UserServiceType;
import kz.pashim.kubedockertest.service.UserStrategyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("file/users")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserFileController {

    private final UserStrategyService userStrategyService;

    @GetMapping
    public List<UserDTO> getUsers() {
        log.info("getUsers endpoint was triggered");
        return userStrategyService.getUserService(UserServiceType.FILE).getUsers();
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO user) {
        log.info("addUser endpoint was triggered");
        return userStrategyService.getUserService(UserServiceType.FILE).addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        log.info("deleteUser endpoint was triggered");
        userStrategyService.getUserService(UserServiceType.FILE).deleteUser(id);
    }
}