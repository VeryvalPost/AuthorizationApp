package ru.homework.authorizationapp.service;

import org.springframework.stereotype.Service;
import ru.homework.authorizationapp.exception.InvalidCredentials;
import ru.homework.authorizationapp.exception.UnauthorizedUser;
import ru.homework.authorizationapp.model.Authorities;
import ru.homework.authorizationapp.model.User;
import ru.homework.authorizationapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public ArrayList<User> addUser (String user, String password, Authorities[] authorities) {
        ArrayList<User> userRep =userRepository.addUser(user,password,authorities);
        return userRep;
    }

}