package com.adventofcode.common;

public class GridHelper {
  public static <T> boolean isInBounds(T[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
  }
}
