package com.adventofcode.year2024.day14;

public class CenterOfMassCalculator {

  // Directions: right, left, down, up, and the four diagonals
  private static final int[] DIRECTIONS_X = {0, 0, 1, -1, 1, -1, 1, -1};
  private static final int[] DIRECTIONS_Y = {1, -1, 0, 0, 1, 1, -1, -1};

  public static Result findLargestCluster(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    int largestSize = 0;
    int clusterX = -1;
    int clusterY = -1;

    // Iterate over the entire grid
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          // Found an unvisited cluster part, perform DFS to find the entire cluster
          int size = dfs(grid, visited, i, j, rows, cols);
          if (size > largestSize) {
            largestSize = size;
            clusterX = i;
            clusterY = j;
          }
        }
      }
    }

    return new Result(largestSize, clusterX, clusterY);
  }

  // DFS to explore a cluster
  private static int dfs(int[][] grid, boolean[][] visited, int x, int y, int rows, int cols) {
    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0 || visited[x][y]) {
      return 0;
    }

    visited[x][y] = true;
    int clusterSize = 1;

    // Visit all adjacent cells (8 directions)
    for (int i = 0; i < 8; i++) {
      int newX = x + DIRECTIONS_X[i];
      int newY = y + DIRECTIONS_Y[i];
      clusterSize += dfs(grid, visited, newX, newY, rows, cols);
    }

    return clusterSize;
  }

  // Result class to store the size and position of the largest cluster
  static class Result {
    int size;
    int x, y;

    Result(int size, int x, int y) {
      this.size = size;
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Size: " + size + ", X: " + x + ", Y: " + y;
    }
  }
}
