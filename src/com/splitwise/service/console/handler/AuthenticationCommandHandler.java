package com.splitwise.service.console.handler;

import com.splitwise.Splictwise;
import com.splitwise.service.authentication.AuthenticationContext;
import com.splitwise.service.authentication.ConsoleAuthenticationContext;
import com.splitwise.service.console.command.AddGroupCommand;
import com.splitwise.service.console.command.IAuthenticateCommand;
import com.splitwise.service.console.command.ICommand;

import java.util.List;

public class AuthenticationCommandHandler extends ConsoleCommandHandler implements ICommand {



    public AuthenticationCommandHandler(Splictwise splictwise){
        this.authenticationContext = new ConsoleAuthenticationContext(splictwise.userRepository);
    }
    AuthenticationContext authenticationContext;

    @Override
    public boolean matches(List<String> input) {

        if(input.size() < 2) return false;
        try{
            if(input.get(0).toLowerCase().charAt(0) == 'u') {
                long userid = Long.parseLong(input.get(0)
                        .toLowerCase().substring(1, input.get(0).length()));


            }
        } catch (NumberFormatException e) {
            return false;
        }
        return super.matches(input.subList(1, input.size()));
    }

    @Override
    public void execute(List<String> input) {

            if(!input.isEmpty() && input.get(0).toLowerCase().charAt(0) == 'u') {
                long userId = Long.parseLong(input.get(0)
                        .toLowerCase().substring(1));

                authenticationContext.setUserId(userId);

                ICommand  command = getCommand(input.subList(1, input.size()));
                if(command instanceof IAuthenticateCommand) {
                    ((IAuthenticateCommand)command).setAuthenticationContext(authenticationContext);
                }
                command.execute(input);

            }

    }
}
