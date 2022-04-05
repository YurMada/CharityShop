package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class EmployeeEntityTest {

    @Test
    void setUsername() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setUsername("Adam112");

        assertThat(employeeEntity.getUsername()).isEqualTo("Adam112");
    }

    @Test
    void setEmail() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("adam.long@yahoo.com");

        assertThat(employeeEntity.getEmail()).isEqualTo("adam.long@yahoo.com");

    }

    @Test
    void setPassword() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("Goteborg2020");

        assertThat(employeeEntity.getPassword()).isEqualTo("Goteborg2020");

    }

    @Test
    void setId() {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(99L);

        assertThat(employeeEntity.getId()).isEqualTo(99L);

    }
}