package com.splitwise.service.console.handler;

import com.splitwise.service.console.command.ICommand;

import java.util.List;

public interface CommandHandler extends ICommand {
    void execute(List<String> input);

    boolean matches(List<String> input);

    void registerCommand(ICommand command);


    ICommand getCommand(List<String> input);
}
