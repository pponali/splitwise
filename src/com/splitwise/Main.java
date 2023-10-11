package com.splitwise;

import com.splitwise.service.console.command.AddGroupCommand;
import com.splitwise.service.console.command.ExitCommand;
import com.splitwise.service.console.command.RegisterCommand;
import com.splitwise.service.console.handler.AuthenticationCommandHandler;
import com.splitwise.service.console.handler.CommandHandler;
import com.splitwise.service.console.handler.ConsoleCommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        Splictwise splictwise = new Splictwise();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AuthenticationCommandHandler authenticationCommandHandler = new AuthenticationCommandHandler(splictwise);
        authenticationCommandHandler.registerCommand(new AddGroupCommand(splictwise));

        CommandHandler commandHandler = new ConsoleCommandHandler();
        commandHandler.registerCommand(new RegisterCommand(splictwise));
        commandHandler.registerCommand(new ExitCommand());
        commandHandler.registerCommand(authenticationCommandHandler);


        while (true) {
            System.out.print("\n>");
            List<String> input = Arrays.asList(br.readLine().split(" "));
            try {
                commandHandler.execute(input);
            } catch (Exception e) {
                System.out.print(e.getClass().getSimpleName() + " : " + e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}