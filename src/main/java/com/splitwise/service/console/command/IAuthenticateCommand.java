package com.splitwise.service.console.command;

import com.splitwise.service.authentication.AuthenticationContext;

public interface IAuthenticateCommand extends ICommand {
    public void setAuthenticationContext(AuthenticationContext authentiationContext);
}
