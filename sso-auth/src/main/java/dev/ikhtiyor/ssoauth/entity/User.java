package dev.ikhtiyor.ssoauth.entity;

import dev.ikhtiyor.ssoauth.enums.AuthProviderEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
@Entity(name = "users")
public class User implements OAuth2User, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String imageUrl;

    private Boolean emailVerified = false;

    private String password = null;

    private AuthProviderEnum provider;

    private String providerId;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Transient
    private Map<String, Object> attributes;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
}
