package com.example.budjet_spring.Services;

import com.example.budjet_spring.Entity.Family;
import org.springframework.stereotype.Service;

/**
 * Created by .
 */
@Service
public interface FamilyService {
    Family getByLoginAndPassword(String login, String password);

    void registration(String login, String password);
}
