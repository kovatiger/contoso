package app;

import app.entity.Role;
import app.entity.User;
import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired UserService userService) {
        return args -> {
            if (userService.findByLogin("ADMIN") == null) {
                User user = new User();
                user.setLogin("ADMIN");
                user.setPassword("ADMIN");
                Role role = new Role();
                role.setRoleName("ADMIN");
                user.setRole(role);
                userService.saveUser(user);
            }
            if (userService.findByLogin("USER") == null) {
                User user = new User();
                user.setLogin("USER");
                user.setPassword("USER");
                Role role = new Role();
                role.setRoleName("USER");
                user.setRole(role);
                userService.saveUser(user);
            }
        };
    }


}
