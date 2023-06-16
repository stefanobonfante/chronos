package it.addvalue.chronos.utils;

import it.addvalue.chronos.model.RelationalOperator;
import it.addvalue.chronos.model.entity.User;
import lombok.NonNull;

public final class UserUtils {
  private UserUtils() {}

  public static boolean hasLevel(
      final @NonNull User user, final @NonNull RelationalOperator operator, final int value) {
    switch (operator) {
      case LT:
        return user.getLevel() < value;

      case GT:
        return user.getLevel() > value;

      case LTE:
        return user.getLevel() <= value;

      case GTE:
        return user.getLevel() >= value;

      case EQ:
        return user.getLevel() == value;

      case NE:
        return user.getLevel() != value;

      default:
        throw new IllegalArgumentException("Relational operator not managed.");
    }
  }
}
