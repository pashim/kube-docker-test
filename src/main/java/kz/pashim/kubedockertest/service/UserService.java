package kz.pashim.kubedockertest.service;

import kz.pashim.kubedockertest.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO addUser(UserDTO user);
    void deleteUser(UUID id);
}
