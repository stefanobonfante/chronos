package it.addvalue.chronos.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.addvalue.chronos.ChronosApplication;
import it.addvalue.chronos.model.entity.User;

@SpringBootTest(classes = ChronosApplication.class)
public class UserRepositoryTests {
  @Autowired private IUserRepository repository;

  @Test
  public void testFetchData() {
    List<User> users = repository.findAll();
    assertNotNull(users);
  }
}
