package com.splitwise.models;

import com.splitwise.exception.validation.InvalidUserNameException;
import com.splitwise.exception.validation.InvvalidUserNameException;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class User extends Auditable {

    private String userName;
    private String fullName;
    private String saltedPassword;
    private String phoneNumber;

    @ManyToMany(mappedBy = "participants")
    private List<Expense> expenses;
    @ManyToMany(mappedBy = "members")
    private List<Group> groups;

    public void setUserName(String userName){
        if(userName.length() < 2){
            throw new InvvalidUserNameException("User name should be min 2 chars length");
        }
    }

}
