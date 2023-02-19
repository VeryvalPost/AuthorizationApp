package ru.homework.authorizationapp.repository;

import ru.homework.authorizationapp.model.Authorities;
import ru.homework.authorizationapp.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Repository
public class UserRepository {

    User user1 = new User("Valeriy", "11111", new Authorities[]{Authorities.READ,Authorities.WRITE});
    User user2 = new User("Viktor", "22222", new Authorities[]{Authorities.READ,Authorities.WRITE,Authorities.DELETE});
    User user3 = new User("Valentin", "33333", new Authorities[]{Authorities.READ});
    ArrayList<User> repository = new ArrayList<User>(Arrays.asList(user1,user2,user3));

    public ArrayList<User> addUser (@PathVariable String user, @PathVariable String password, Authorities[] authorities){
        User userNew = new User(user, password, authorities);
        repository.add(userNew);
        return repository;
    }

    public List<Authorities> getUserAuthorities(@PathVariable String user, @PathVariable String password) {
        for (User entry: repository)  {
            if (entry.getUser().equals(user)&entry.getPassword().equals(password)) {
                return entry.getAuthorities();
            }
        }
        return new ArrayList<>();
    }
}
