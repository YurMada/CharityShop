package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class UserEntityTest {

    @Test
    void ifGetIdShouldReturnSameId() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);

        assertThat(userEntity.getId()).isEqualTo(1L);
    }

    @Test
    void IfGetUsernameShouldReturnSameUserName() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("USER1");

        assertThat(userEntity.getUsername()).isEqualTo("USER1");
    }

    @Test
    void setEmailShouldReturnSameEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("kalle@anka.se");

        assertThat(userEntity.getEmail()).isEqualTo("kalle@anka.se");
    }

    @Test
    void setPasswordShouldReturnSamePassword() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("12345");

        assertThat(userEntity.getPassword()).isEqualTo("12345");
    }

}