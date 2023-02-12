package authorization.repository;

import authorization.model.Authorities;
import authorization.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class UserRepository {
    ConcurrentHashMap<Integer, User> repositoryUser = new ConcurrentHashMap<>();
    AtomicInteger index;

    public void addUser(@PathVariable String user, @PathVariable String password, Authorities[] authorities)
    {
    User newUser = new User(user,password,authorities);
    repositoryUser.put(index.getAndIncrement(), newUser);
    }
    public List<Authorities> getUserAuthorities(@PathVariable String user, @PathVariable String password) {
    return null;
    }
}
