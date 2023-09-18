package dev.ikhtiyor.ssoauth.controller;

import dev.ikhtiyor.ssoauth.entity.User;
import dev.ikhtiyor.ssoauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @GetMapping("/profile")
    public User getCurrentUser() {
        return service.getCurrentUser();
    }
}
