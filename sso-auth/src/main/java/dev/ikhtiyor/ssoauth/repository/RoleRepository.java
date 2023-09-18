package dev.ikhtiyor.ssoauth.repository;

import dev.ikhtiyor.ssoauth.entity.Role;
import dev.ikhtiyor.ssoauth.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleNameEnum name);

}
