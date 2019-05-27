package md.codefactory.userservice.repository;

import md.codefactory.userservice.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(value = {"/sql-scripts/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void find_by_id_test() {
        Optional<User> actualUser = usersRepository.findById(1L);
        assertTrue(actualUser.isPresent());
    }

    @Test
    public void find_all_test() {
        List<User> actualUserSize = usersRepository.findAll();
        assertEquals(10, actualUserSize.size());
    }

    @Test
    public void find_by_email_test() {
        Optional<User> actualUser = usersRepository.findByEmail("petea@codefactory.com");
        assertTrue(actualUser.isPresent());
    }

    @Test
    public void find_by_phone_number() {
        Optional<User> actualUser = usersRepository.findByPhoneNumber("069545458");
        assertTrue(actualUser.isPresent());
    }

    @Test
    public void find_by_username() {
        Optional<User> actualUser = usersRepository.findByUsername("petea4");
        assertTrue(actualUser.isPresent());
    }

}