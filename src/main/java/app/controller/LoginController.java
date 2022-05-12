package app.controller;

import app.dto.UserDto;
import app.entity.User;
import app.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/authorization")
    public ResponseEntity<UserDto> authorization(@RequestBody UserDto userDto) {
        User user = userService.findByLogin(userDto.getLogin());
        if (user != null && user.getPassword().equals(userDto.getPassword())) {
            userDto.setRole(user.getRole().getRoleName());
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
