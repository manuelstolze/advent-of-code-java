package com.adventofcode.year2024.day04;

import java.util.List;

public class InputConverter {

  public char[][] convertToCharGrid(List<String> lines) {
    return initGrid(lines);
  }

  private char[][] initGrid(List<String> lines) {
    int rows = lines.size();
    int cols = lines.get(0).length();
    char[][] grid = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      grid[i] = lines.get(i).toCharArray();
    }
    return grid;
  }
}
