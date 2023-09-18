package dev.ikhtiyor.ssoauth.util;

import dev.ikhtiyor.ssoauth.entity.User;
import dev.ikhtiyor.ssoauth.exception.UnauthorizedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class CommonUtils {

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null
                || !authentication.isAuthenticated()
                || "anonymousUser".equals(String.valueOf(authentication.getPrincipal())))
            throw new UnauthorizedException("Unauthorized User");
        return (User) authentication.getPrincipal();
    }

    public static Long getCurrentUserId() {
        User currentUser = getCurrentUser();
        return currentUser.getId();
    }


}
