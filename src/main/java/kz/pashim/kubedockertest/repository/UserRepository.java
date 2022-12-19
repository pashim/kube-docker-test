package kz.pashim.kubedockertest.repository;

import kz.pashim.kubedockertest.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
