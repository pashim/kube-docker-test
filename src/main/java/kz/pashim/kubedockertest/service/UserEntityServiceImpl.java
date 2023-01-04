package kz.pashim.kubedockertest.service;

import kz.pashim.kubedockertest.domain.UserEntity;
import kz.pashim.kubedockertest.dto.UserDTO;
import kz.pashim.kubedockertest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        var entity = userRepository.save(UserEntity.builder().name(userDTO.getName()).build());
        return UserDTO.builder().name(entity.getName()).id(entity.getId()).build();
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(it -> UserDTO.builder().id(it.getId()).name(it.getName()).build())
                .collect(Collectors.toList()) ;
    }
}
