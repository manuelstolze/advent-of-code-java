package com.adventofcode.common;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
  HORIZONTAL_RIGHT,
  HORIZONTAL_LEFT,

  VERTICAL_UP,
  VERTICAL_DOWN,

  DIAGONAL_RIGHT_UP,
  DIAGONAL_RIGHT_DOWN,
  DIAGONAL_LEFT_UP,
  DIAGONAL_LEFT_DOWN;


  public static List<Integer> getDirectionVectors(Direction direction){
    switch (direction) {
      case HORIZONTAL_RIGHT:
        return new ArrayList<>(List.of(0, 1));
      case HORIZONTAL_LEFT:
        return new ArrayList<>(List.of(0, -1));
      case VERTICAL_UP:
        return new ArrayList<>(List.of(1, 0));
      case VERTICAL_DOWN:
        return new ArrayList<>(List.of(-1, 0));
      case DIAGONAL_RIGHT_UP:
        return new ArrayList<>(List.of(1, 1));
      case DIAGONAL_RIGHT_DOWN:
        return new ArrayList<>(List.of(1, -1));
      case DIAGONAL_LEFT_UP:
        return new ArrayList<>(List.of(-1, 1));
      case DIAGONAL_LEFT_DOWN:
        return new ArrayList<>(List.of(-1, -1));
      default:
        throw new IllegalArgumentException("Invalid direction");
    }
  }
}
