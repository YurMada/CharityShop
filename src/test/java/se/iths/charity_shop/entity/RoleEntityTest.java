package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class RoleEntityTest {

    @Test
    void setIdShouldReturnSameId() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(88L);

        assertThat(roleEntity.getId()).isEqualTo(88L);
    }

    @Test
    void setRoleShouldReturnSameRole() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole("BigBoss");

        assertThat(roleEntity.getRole()).isEqualTo("BigBoss");

    }
}