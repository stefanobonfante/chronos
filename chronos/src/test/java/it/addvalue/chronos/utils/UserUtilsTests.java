package it.addvalue.chronos.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.addvalue.chronos.model.RelationalOperator;
import it.addvalue.chronos.model.entity.User;

public class UserUtilsTests {
  @Test
  public void levelEqualReturnTrueTest() {
    User user = new User();
    user.setLevel(1);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.EQ, 1));
  }

  @Test
  public void levelEqualReturnFalseTest() {
    User user = new User();
    user.setLevel(1);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.EQ, 99));
  }

  @Test
  public void levelNotEqualReturnTrueTest() {
    User user = new User();
    user.setLevel(1);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.NE, 99));
  }

  @Test
  public void levelNotEqualReturnFalseTest() {
    User user = new User();
    user.setLevel(1);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.NE, 1));
  }

  @Test
  public void levelGreaterThanReturnTrueTest() {
    User user = new User();
    user.setLevel(5);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.GT, 1));
  }

  @Test
  public void levelGreaterThanReturnFalseTest() {
    User user = new User();
    user.setLevel(5);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.GT, 5));
  }

  @Test
  public void levelLessThanReturnTrueTest() {
    User user = new User();
    user.setLevel(5);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.LT, 99));
  }

  @Test
  public void levelLessThanReturnFalseTest() {
    User user = new User();
    user.setLevel(5);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.LT, 5));
  }

  @Test
  public void levelGreaterThanOrEqualReturnTrueTest() {
    User user = new User();
    user.setLevel(5);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.GTE, 5));
  }

  @Test
  public void levelGreaterThanOrEqualReturnFalseTest() {
    User user = new User();
    user.setLevel(5);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.GTE, 99));
  }

  @Test
  public void levelLessThanOrEqualReturnTrueTest() {
    User user = new User();
    user.setLevel(5);
    assertTrue(UserUtils.hasLevel(user, RelationalOperator.LTE, 5));
  }

  @Test
  public void levelLessThanOrEqualReturnFalseTest() {
    User user = new User();
    user.setLevel(5);
    assertFalse(UserUtils.hasLevel(user, RelationalOperator.LTE, 1));
  }

  @Test
  public void hasLevelNonNullTest() {
    assertThrows(
        NullPointerException.class,
        () -> {
          UserUtils.hasLevel(null, null, 1);
        });
  }
}
