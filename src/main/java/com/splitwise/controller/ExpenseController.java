package com.splitwise.controller;

import com.splitwise.exception.notfound.GroupNotFoundException;
import com.splitwise.exception.notfound.UserNotFOuntException;
import com.splitwise.models.Expense;
import com.splitwise.models.Group;
import com.splitwise.models.User;
import com.splitwise.repository.GroupRepository;
import com.splitwise.repository.UserRepository;
import com.splitwise.service.authentication.AuthenticationContext;
import com.splitwise.service.payment.PaymentStrategy;
import com.splitwise.service.split.SplitStrategy;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;


@Controller
public class ExpenseController {

    UserRepository userRepository;

    GroupRepository groupRepository;

    public ExpenseController(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }


    /**
     *
     * @param authenticationException
     * @param participantIds
     * @param description
     * @param date
     * @param paymentStrategy
     * @param splitStrategy
     * @return
     */
    public Expense createExpenseWithParticipents(
            AuthenticationContext authenticationException,
            List<Long> participantIds,
            String description,
            Date date,
            PaymentStrategy paymentStrategy,
            SplitStrategy splitStrategy) {

        User user = authenticationException.getCurrentlyLoggedinUser()
                .orElseThrow(() -> new UserNotFOuntException(""));

        List<User> participants = participantIds
                .stream()
                .map((id) -> userRepository
                        .findById(id)
                        .orElseThrow(() -> new UserNotFOuntException(id.toString())))
                .toList();
        participants.add(user);

        Expense expense = new Expense(participants, date, description);

        paymentStrategy.calculatePaidAmouts(expense);
        splitStrategy.calculateOwedAmounts(expense);

        return expense;


    }

    /**
     *
     * @param authenticationException
     * @param groupId
     * @param description
     * @param date
     * @param paymentStrategy
     * @param splitStrategy
     * @return
     */

    public Expense createExpenseWithGroup(
            AuthenticationContext authenticationException,
            Long groupId,
            String description,
            Date date,
            PaymentStrategy paymentStrategy,
            SplitStrategy splitStrategy) {

        Group group = groupRepository.findById(groupId)
                .orElseThrow(
                        () -> new GroupNotFoundException("Group not found" + groupId.toString()));

        List<User> participants = group.getMembers();

        Expense expense = new Expense(participants, date, description);

        paymentStrategy.calculatePaidAmouts(expense);
        splitStrategy.calculateOwedAmounts(expense);
        return expense;

    }
}
