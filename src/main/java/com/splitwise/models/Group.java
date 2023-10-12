package com.splitwise.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name ="user_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)

public class Group extends Auditable {


    private String name;

    @OneToOne
    private User admin;

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Expense> expenses;

}
