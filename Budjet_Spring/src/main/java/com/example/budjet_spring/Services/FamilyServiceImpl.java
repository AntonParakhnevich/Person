package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.Budget;
import com.example.budjet_spring.Entity.Family;
import com.example.budjet_spring.Repositories.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by .
 */
@Service
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository familyRepository;

    public Family getByLoginAndPassword(String login, String password) {
        Family family = null;
        try {
            System.out.println("family :: " + familyRepository.getLoginAndPassword(login, password));
            family = familyRepository.getLoginAndPassword(login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return family;
    }

    public void registration(String login, String password) {
        Budget budget = Budget.builder().build();
        Family family = Family.builder()
                .login(login)
                .password(password)
                .budget(budget)
                .build();
        budget.setFamily(family);
        familyRepository.save(family);
    }
}
