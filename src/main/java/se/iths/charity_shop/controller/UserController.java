package se.iths.charity_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.exception.ApiRequestException;
import se.iths.charity_shop.repository.UserRepository;
import se.iths.charity_shop.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("users")

public class UserController {
    UserService userService;
    Logger logger= LoggerFactory.getLogger(UserController.class);
    public UserController(UserService userService){
        this.userService=userService;}

    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        UserEntity createdUser=userService.createUser(userEntity);
        logger.trace("vi loggar på TRACE-nivå");
        logger.debug("wi loggar på DEBUG-nivå");
        logger.info("vi loggar på INFO-nivå");
        logger.warn("vi loggar på WARN-nivå");
        logger.error("vi loggar på ERROR-nivå");
        return new ResponseEntity(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }


    @GetMapping("{id}")
    public Optional<UserEntity> findUserById(@PathVariable Long id){
        return userService.findUserById(id);

    }

    @GetMapping("")
    public Iterable<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }
}

