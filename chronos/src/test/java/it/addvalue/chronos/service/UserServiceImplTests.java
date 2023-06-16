package it.addvalue.chronos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import it.addvalue.chronos.ChronosApplication;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.repository.IUserRepository;

@SpringBootTest(classes = ChronosApplication.class)
public class UserServiceImplTests {
  @InjectMocks UserServiceImpl userService = new UserServiceImpl();
  @Mock IUserRepository userRepository;

  @BeforeEach
  void init() {
    Mockito.when(userRepository.findAll())
        .thenReturn(
            Arrays.asList(
                new User("user_alfa", "alfa", "alfa", 1),
                new User("user_beta", "beta", "beta", 99)));
  }

  @Test
  public void findAllTest() {
    List<User> users = userService.findAll();
    assertNotNull(users);
    assertEquals(2, users.size());
    assertEquals("user_alfa", users.get(0).getUserCode());
    assertEquals("alfa", users.get(0).getName());
    assertEquals("alfa", users.get(0).getSurname());
    assertEquals(1, users.get(0).getLevel());
    assertEquals("user_beta", users.get(1).getUserCode());
    assertEquals("beta", users.get(1).getName());
    assertEquals("beta", users.get(1).getSurname());
    assertEquals(99, users.get(1).getLevel());
  }
}
