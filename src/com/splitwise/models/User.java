package com.splitwise.models;

import com.splitwise.exception.validation.InvalidUserNameException;

import java.util.List;

public class User extends Auditable {

    private String userName;
    private String fullName;
    private String saltedPassword;
    private String phoneNumber;

    private List<Expense> expenses;
    private List<Group> groups;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.length() <3) {
            throw new InvalidUserNameException("User name should be min of 5 char length!!");
        }
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSaltedPassword() {
        return saltedPassword;
    }

    public void setSaltedPassword(String saltedPassword) {
        this.saltedPassword = saltedPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
