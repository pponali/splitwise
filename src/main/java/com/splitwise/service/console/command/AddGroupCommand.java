package com.splitwise.service.console.command;

import com.splitwise.Splictwise;
import com.splitwise.controller.GroupController;
import com.splitwise.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddGroupCommand extends AbstractAuthenticatedCommand{

    final GroupController groupController;

    public Splictwise splictwise;



    public AddGroupCommand(final GroupController groupController) {

        this.groupController = groupController;
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
