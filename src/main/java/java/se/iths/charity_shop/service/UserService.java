package java.se.iths.charity_shop.service;

import org.springframework.stereotype.Service;

import java.se.iths.charity_shop.entity.UserEntity;
import java.se.iths.charity_shop.repository.UserRepository;

@Service
public class UserService {


    public UserEntity createUser(UserEntity userEntity){
        return userEntity;
    }

}
