package com.splitwise.controller;

import com.splitwise.dto.UserDTO;
import com.splitwise.exception.authentication.NotLoggerInUserException;
import com.splitwise.exception.authentication.PasswordDoesNotMatchException;
import com.splitwise.exception.validation.DuplicateUsernameException;
import com.splitwise.models.Expense;
import com.splitwise.models.Group;
import com.splitwise.models.User;
import com.splitwise.repository.ExpenseRepository;
import com.splitwise.repository.GroupRepository;
import com.splitwise.repository.UserRepository;
import com.splitwise.service.authentication.AuthenticationContext;
import com.splitwise.service.authentication.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * Client 1 -> deals with read operation
 * Client 2 -> deals with password update operation
 *
 * For client 1 - password encoder is not required.
 * For client 2 - password encoder is required.
 *
 * Hence instead of doing Dependency injection forcefully.
 * Set the password encoder with setter and getter.
 *
 * So client 1 does not require to inject password encoder.
 */


@Controller
public class UserController {

    UserRepository userRepository;

    final ExpenseRepository expenseRepository;

    final GroupRepository groupRepository;


    final private PasswordEncoder passwordEncoder;




    public UserController(UserRepository userRepository, final ExpenseRepository expenseRepository, final GroupRepository groupRepository, final PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Create User
    //This method requires password encoder to be set.

    public User register(UserDTO details) {

        if(userRepository.findByUserName(details.userName).isPresent()) {
            throw new DuplicateUsernameException("User already exist!");
        }
        User user = new User();
        user.setUserName(details.userName);
        user.setPhoneNumber(details.phoneNumber);
        user.setFullName(details.fullName);
        user.setSaltedPassword(passwordEncoder.encode(details.password, details.userName));
        userRepository.save(user);
        return user;

    }

    public void changePassword(AuthenticationContext authentiationContext, String oldpassword, String password){

        User user = authentiationContext.getCurrentlyLoggedinUser().
                orElseThrow(
                        () -> new NotLoggerInUserException("User needs to login to change the password!"));
        if(!user.getSaltedPassword().equals(passwordEncoder.encode(oldpassword, user.getUserName()))){
            throw new PasswordDoesNotMatchException("Password does not match Exception!");
        }

        user.setSaltedPassword(passwordEncoder.encode(password, user.getUserName()));
        userRepository.save(user);


    }

    public void updateProfile(AuthenticationContext authentiationContext, UserDTO newDetails){
        User user = authentiationContext.getCurrentlyLoggedinUser()
                .orElseThrow(() -> new NotLoggerInUserException("User needs to login to change the password!"));

        user.setPhoneNumber(newDetails.phoneNumber);
        user.setFullName(newDetails.fullName);

        userRepository.save(user);


    }

    public Double getTotalAmountsOwed(AuthenticationContext authentiationContext) {

        return 0.0;
    }

    public List<Expense> listOfExpences(AuthenticationContext authentiationContext) {
        User user = authentiationContext.getCurrentlyLoggedinUser()
                .orElseThrow(() -> new NotLoggerInUserException("User needs to login to change the password!"));
        return user.getExpenses();
    }

    public List<Group>  myGroups(AuthenticationContext authentiationContext) {
        User user = authentiationContext.getCurrentlyLoggedinUser()
                .orElseThrow(() -> new NotLoggerInUserException("User needs to login to change the password!"));
        return user.getGroups();
    }

}
