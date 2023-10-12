package com.splitwise.service.console.handler;

import com.splitwise.repository.UserRepository;
import com.splitwise.service.authentication.AuthenticationContext;
import com.splitwise.service.authentication.ConsoleAuthenticationContext;
import com.splitwise.service.console.command.IAuthenticateCommand;
import com.splitwise.service.console.command.ICommand;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthenticationCommandHandler extends ConsoleCommandHandler implements ICommand {


    final UserRepository userRepository;


    public AuthenticationCommandHandler(final UserRepository userRepository){
        this.userRepository = userRepository;
        this.authenticationContext = new ConsoleAuthenticationContext(this.userRepository);
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
