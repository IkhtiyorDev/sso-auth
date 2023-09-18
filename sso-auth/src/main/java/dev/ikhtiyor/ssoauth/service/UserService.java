package dev.ikhtiyor.ssoauth.service;

import dev.ikhtiyor.ssoauth.entity.User;
import dev.ikhtiyor.ssoauth.exception.ResourceNotFoundException;
import dev.ikhtiyor.ssoauth.repository.UserRepository;
import dev.ikhtiyor.ssoauth.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );
    }

    public UserDetails loadUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

    }

    public User getCurrentUser() {
        Long currentUserId = CommonUtils.getCurrentUserId();
        return userRepository.findById(currentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUserId));
    }
}
