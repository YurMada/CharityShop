package java.se.iths.charity_shop.repository;

import org.springframework.data.repository.CrudRepository;

import java.se.iths.charity_shop.entity.UserEntity;

public interface UserRepository extends CrudRepository {
    UserEntity findByUsername(String username);
}
