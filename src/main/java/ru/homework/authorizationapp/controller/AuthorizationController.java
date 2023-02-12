package authorization.controller;

import authorization.service.AuthorizationService;
import authorization.model.Authorities;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/add")
    public void addUser(@RequestParam("user") String user, @RequestParam("password") String password, @RequestParam("authorities") Authorities[] authorities) {
        service.addUser(user, password, authorities);
    }
}