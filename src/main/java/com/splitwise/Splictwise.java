package com.splitwise;

import com.splitwise.controller.ExpenseController;
import com.splitwise.controller.GroupController;
import com.splitwise.controller.UserController;
import com.splitwise.repository.ExpenseRepository;
import com.splitwise.repository.GroupRepository;
import com.splitwise.repository.UserRepository;
import com.splitwise.service.authentication.PasswordEncoder;
import com.splitwise.service.authentication.PlainTextPasswordEncoder;

public class Splictwise {
    public UserController userController;
    public GroupController groupController;
    public ExpenseController expenseController;
    public UserRepository userRepository;
    public GroupRepository groupRepository;
    public ExpenseRepository expenseRepository;
    public PasswordEncoder passwordEncoder;

    public Splictwise() {

        this.userRepository = null;

        this.userController = new UserController(userRepository, expenseRepository, groupRepository, passwordEncoder);
        this.groupController = new GroupController(userRepository, expenseRepository, groupRepository);
        this.expenseController = new ExpenseController(userRepository, groupRepository);
        this.passwordEncoder = PlainTextPasswordEncoder.getInstance();

    }

}
