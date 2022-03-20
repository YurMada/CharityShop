package se.iths.charity_shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.repository.RoleRepository;

@SpringBootApplication
public class CharityShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpRoles(RoleRepository roleRepository){
        return (args) -> {
            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_USER"));
            roleRepository.save(new RoleEntity("ROLE_ECONOMY"));
        };
    }

}
