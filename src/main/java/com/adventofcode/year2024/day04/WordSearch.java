package com.adventofcode.year2024.day04;

import com.adventofcode.common.Direction;

public class WordSearch {
  String targetWord;
  int targetWordLength;

  public WordSearch(String targetWord) {
    this.targetWord = targetWord;
    this.targetWordLength = targetWord.length();
  }

  public boolean isWordPresent(char[][] grid, int row, int col, Direction direction) {
    int dRow = Direction.getDirectionVectors(direction).get(0);
    int dCol = Direction.getDirectionVectors(direction).get(1);

    for (int i = 0; i < this.targetWordLength; i++) {
      int newRow = row + i * dRow;
      int newCol = col + i * dCol;

      if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
        return false;
      }

      if (grid[newRow][newCol] != this.targetWord.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public int countWordOccurrences(char[][] grid) {
    int count = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        for (Direction direction : Direction.values()) { // Check all directions
          if (isWordPresent(grid, row, col, direction)) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public int countWordsInXShape(char[][] grid) {
    int count = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        count += checkForXMAS(grid, row, col);
      }
    }
    return count;
  }

  private int checkForXMAS(char[][] grid, int row, int col) {
    int count = 0;

    // Check if the center is 'A'
    if (grid[row][col] == 'A') {
      if (isInBounds(grid, row - 1, col - 1)
          && isInBounds(grid, row - 1, col + 1)
          && isInBounds(grid, row + 1, col - 1)
          && isInBounds(grid, row + 1, col + 1)) {
        if (grid[row - 1][col - 1] == 'M'
            && grid[row + 1][col + 1] == 'S'
            && grid[row + 1][col - 1] == 'M'
            && grid[row - 1][col + 1] == 'S') {
          count++;
        }

        if (grid[row - 1][col - 1] == 'M'
            && grid[row + 1][col + 1] == 'S'
            && grid[row + 1][col - 1] == 'S'
            && grid[row - 1][col + 1] == 'M') {
          count++;
        }

        if (grid[row - 1][col - 1] == 'S'
            && grid[row + 1][col + 1] == 'M'
            && grid[row + 1][col - 1] == 'M'
            && grid[row - 1][col + 1] == 'S') {
          count++;
        }

        if (grid[row - 1][col - 1] == 'S'
            && grid[row + 1][col + 1] == 'M'
            && grid[row + 1][col - 1] == 'S'
            && grid[row - 1][col + 1] == 'M') {
          count++;
        }
      }
    }

    return count;
  }

  private boolean isInBounds(char[][] grid, int row, int col) {
    return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
  }
}
