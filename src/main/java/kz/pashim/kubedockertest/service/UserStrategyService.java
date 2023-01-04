package kz.pashim.kubedockertest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStrategyService {

    private final UserFileServiceImpl userFileService;
    private final UserEntityServiceImpl userEntityService;

    public UserService getUserService(UserServiceType type) {
        switch (type) {
            case FILE -> {
                return userFileService;
            }
            case ENTITY -> {
                return userEntityService;
            }
            default -> throw new IllegalArgumentException("Undefined user service type");
        }
    }
}
