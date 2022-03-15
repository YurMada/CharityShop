package se.iths.charity_shop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
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
