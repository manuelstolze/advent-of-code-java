package com.adventofcode.year2024.day06;

public enum GuardDirection {
  UP,
  DOWN,
  LEFT,
  RIGHT;

  public static GuardDirection getDirectionByChar(char direction) {
    return switch (direction) {
      case '^' -> UP;
      case 'v' -> DOWN;
      case '<' -> LEFT;
      case '>' -> RIGHT;
      default -> throw new IllegalArgumentException("Invalid direction: " + direction);
    };
  }
}
