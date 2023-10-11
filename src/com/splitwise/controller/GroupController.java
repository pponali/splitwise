package com.splitwise.controller;

import com.splitwise.exception.authentication.NotLoggerInUserException;
import com.splitwise.models.Group;
import com.splitwise.models.User;
import com.splitwise.repository.ExpenseRepository;
import com.splitwise.repository.GroupRepository;
import com.splitwise.repository.UserRepository;
import com.splitwise.service.authentication.AuthenticationContext;

import java.util.List;

public class GroupController {

    UserRepository userRepository;

    ExpenseRepository expenseRepository;

    GroupRepository groupRepository;

    public GroupController(
            UserRepository userRepository,
            ExpenseRepository expenseRepository,
            GroupRepository groupRepository){

        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;

    }

    public Group createGroup(AuthenticationContext authenticationContext, List<User> participants, String name) {

        User user = authenticationContext.getCurrentlyLoggedinUser().orElseThrow(() -> new NotLoggerInUserException("User not yet logged in"));
        participants.add(user);
        Group group = new Group();
        group.setAdmin(user);
        group.setName(name);
        group.setMembers(participants);
        group = groupRepository.create(group);
        System.out.println("Group created : " + group);

        return group;


    }
}
