package se.iths.charity_shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.repository.RoleRepository;

@SpringBootApplication
public class CharityShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharityShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpRoles(RoleRepository roleRepository) {
        return (args) -> {
            if (roleRepository.findByRole("ROLE_ADMIN") == null)
                roleRepository.save(new RoleEntity("ROLE_ADMIN"));

            if (roleRepository.findByRole("ROLE_USER") == null)
                roleRepository.save(new RoleEntity("ROLE_USER"));

            if (roleRepository.findByRole("ROLE_ECONOMY") == null)
                roleRepository.save(new RoleEntity("ROLE_ECONOMY"));
        };
    }

}
