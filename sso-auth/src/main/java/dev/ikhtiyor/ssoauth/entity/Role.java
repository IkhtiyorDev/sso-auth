package dev.ikhtiyor.ssoauth.entity;

import dev.ikhtiyor.ssoauth.enums.RoleNameEnum;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    @Override
    public String getAuthority() {
        return name.name();
    }
}
