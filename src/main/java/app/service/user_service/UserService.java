package app.service.user_service;

import app.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByLogin(String login);

    void saveUser(User user);
}
