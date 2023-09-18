package dev.ikhtiyor.ssoauth.security.oauth2.user;


import dev.ikhtiyor.ssoauth.enums.AuthProviderEnum;
import dev.ikhtiyor.ssoauth.exception.OAuth2AuthenticationProcessingException;

import java.util.Map;


public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProviderEnum.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
