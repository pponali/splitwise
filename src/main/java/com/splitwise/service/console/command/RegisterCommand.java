package com.splitwise.service.console.command;

import com.splitwise.controller.UserController;
import com.splitwise.dto.UserDTO;
import com.splitwise.models.User;
import com.splitwise.service.authentication.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegisterCommand implements ICommand {

    final UserController userController;

    final PasswordEncoder passwordEncoder;

    public RegisterCommand(UserController userController, final PasswordEncoder passwordEncoder) {
        this.userController = userController;
        this.passwordEncoder = passwordEncoder;
        this.userController.setPasswordEncoder(passwordEncoder);
    }
    @Override
    public boolean matches(List<String> input) {
        return input.size() >= 4 && input.get(0).toLowerCase().startsWith("register");
    }

    @Override
    public void execute(List<String> input) {
        UserDTO details = new UserDTO();
        details.userName = input.get(1);
        details.phoneNumber = input.get(2);
        details.password = input.get(3);

        User user = userController.register(details);
        System.out.println(user.toString());

    }
}
