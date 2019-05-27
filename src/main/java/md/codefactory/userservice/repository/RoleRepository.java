package md.codefactory.userservice.repository;

import md.codefactory.userservice.domain.Role;
import md.codefactory.userservice.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
