package ru.homework.authorizationapp.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.homework.authorizationapp.exception.InvalidCredentials;
import ru.homework.authorizationapp.exception.UnauthorizedUser;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println("From exception: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
