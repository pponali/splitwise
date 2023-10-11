package com.splitwise.service.console.command;

import java.util.List;

public interface ICommand {

    boolean matches(List<String> input);

    void execute(List<String> input);
}
