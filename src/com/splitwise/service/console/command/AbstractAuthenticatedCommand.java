package com.splitwise.service.console.command;

import com.splitwise.service.authentication.AuthenticationContext;

public abstract  class AbstractAuthenticatedCommand implements IAuthenticateCommand {
    public AuthenticationContext authenticationContext;



    @Override
    public void setAuthenticationContext(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }
}
