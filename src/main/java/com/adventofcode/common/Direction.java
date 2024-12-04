package com.adventofcode.common;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
  HORIZONTAL,
  VERTICAL,
  DIAGONAL,
  DIAGONAL_2,
  REVERSE_HORIZONTAL,
  REVERSE_VERTICAL,
  REVERSE_DIAGONAL,
  REVERSE_DIAGONAL_2;

  public static List<Integer> getDirectionVectors(Direction direction){
    switch (direction) {
      case HORIZONTAL:
        return new ArrayList<>(List.of(0, 1));
      case VERTICAL:
        return new ArrayList<>(List.of(1, 0));
      case DIAGONAL:
        return new ArrayList<>(List.of(1, 1));
        case DIAGONAL_2:
          return new ArrayList<>(List.of(-1, 1));
      case REVERSE_HORIZONTAL:
        return new ArrayList<>(List.of(0, -1));
      case REVERSE_VERTICAL:
        return new ArrayList<>(List.of(-1, 0));
      case REVERSE_DIAGONAL:
        return new ArrayList<>(List.of(-1, -1));
      case REVERSE_DIAGONAL_2:
        return new ArrayList<>(List.of(1, -1));
      default:
        throw new IllegalArgumentException("Invalid direction");
    }
  }
}
