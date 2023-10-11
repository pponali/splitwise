package com.splitwise.service.console.handler;

import com.splitwise.exception.console.UnSupportedCommandOperation;
import com.splitwise.service.console.command.ICommand;

import java.util.ArrayList;
import java.util.List;

public class ConsoleCommandHandler implements CommandHandler {

    List<ICommand> commands = new ArrayList<>();

    @Override
    public boolean matches(List<String> input) {
        return commands.stream().anyMatch(c -> c.matches(input));
    }

    @Override
    public void execute(List<String> input) {
        getCommand(input).execute(input);

    }

    @Override
    public void registerCommand(ICommand command) {
        commands.add(command);


    }

    @Override
    public ICommand getCommand(List<String> input) {
        for(ICommand command : commands) {
            if(command.matches(input)) {
                return command;
            }
        }
        throw new UnSupportedCommandOperation(input.toString());
    }
}
