package com.splitwise.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Entity
@Table(name ="expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Expense extends Auditable {

    private String description;

    private Date date;

    @ManyToMany
    private List<User> participants;

    private Double totalAmount;
    boolean isSettled;

    @ManyToOne
    private Group group;

    @ElementCollection
    private Map<User, Double> paidAmount;
    @ElementCollection
    private Map<User, Double> owedAmount;

    public Expense(List<User> participants, Date date, String description) {
        this.participants = participants;
        this.date = date;
        this.description = description;
    }

}
