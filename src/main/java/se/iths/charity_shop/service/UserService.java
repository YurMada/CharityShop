package se.iths.charity_shop.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.repository.RoleRepository;
import se.iths.charity_shop.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final RoleRepository roleRepository;

    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd=roleRepository.findByRole("ROLE_ADMIN"); //sätt som en variabel om inte alla ska ha user från början
        userEntity.addRoles(roleToAdd);
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
