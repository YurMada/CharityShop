package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }



}
