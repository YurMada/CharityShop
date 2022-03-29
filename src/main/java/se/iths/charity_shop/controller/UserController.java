package se.iths.charity_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.UserEntity;
import se.iths.charity_shop.exception.BadRequestException;
import se.iths.charity_shop.exception.IdNotFoundException;
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
        if (userEntity == null)
            throw new BadRequestException("This field cannot be empty");

        UserEntity createdUser=userService.createUser(userEntity);
        logger.debug("vi loggar på DEBUG-nivå");
        return new ResponseEntity(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        if (!userService.findUserById(id).isPresent()){
            throw new IdNotFoundException("Sorry, The user:id could not be found");}
        else
        userService.deleteUser(id);
    }


    @GetMapping("{id}")
    public Optional<UserEntity> findUserById(@PathVariable Long id){

        return userService.findUserById(id);

    }

    @GetMapping("")
    public Iterable<UserEntity> findAllUsers() {return userService.findAllUsers();
    }
}

