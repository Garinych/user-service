package md.codefactory.userservice.repository;

import md.codefactory.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

   Optional<User> findById (Long id);
   Optional<User> findByEmail (String email);
   Optional<User> findByPhoneNumber (Integer phoneNumber);
   Optional<User> findByUsername (String username);


}
