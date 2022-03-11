package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.UserEntity;

@Service
public class UserService {


    public UserEntity createUser(UserEntity userEntity){
        return userEntity;
    }

}
