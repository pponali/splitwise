package com.splitwise.service.console.command;

import com.splitwise.Splictwise;
import com.splitwise.controller.GroupController;
import com.splitwise.models.User;

import java.util.ArrayList;
import java.util.List;

public class AddGroupCommand extends AbstractAuthenticatedCommand{

    GroupController groupController;

    public Splictwise splictwise;



    public AddGroupCommand(Splictwise splictwise) {

        this.groupController = splictwise.groupController;
        this.splictwise = splictwise;
    }

    @Override
    public boolean matches(List<String> input) {
        return input.size() >= 2 && input.get(0).toLowerCase().startsWith("addgroup");
    }

    @Override
    public void execute(List<String> input) {
        List<User> participants = new ArrayList<>();
        for (int i = 3; i < input.size(); i++) {
            User user = splictwise.userRepository.findById(Long.parseLong(input.get(i))).orElseThrow();
            participants.add(user);
        }
        groupController.createGroup(authenticationContext, participants, input.get(2));
    }

}
