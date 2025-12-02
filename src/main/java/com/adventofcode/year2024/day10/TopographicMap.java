package com.adventofcode.year2024.day10;

import java.util.ArrayList;
import java.util.List;

public class TopographicMap {
  int[][] heightMap;
  private final int rows;
  private final int columns;

  public TopographicMap(int[][] map) {
    this.heightMap = map;
    this.rows = heightMap.length;
    this.columns = heightMap[0].length;
  }

  int getHeightAt(int x, int y) {
    if (isValidPosition(x, y)) {
      return heightMap[x][y];
    }
    throw new IllegalArgumentException("Position out of bounds: (" + x + ", " + y + ")");
  }

  public boolean isValidPosition(int x, int y) {
    return x >= 0 && x < rows && y >= 0 && y < columns;
  }

  public List<int[]> findTrailheads() {
    List<int[]> trailheads = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (heightMap[i][j] == 0) {
          trailheads.add(new int[] {i, j});
        }
      }
    }
    return trailheads;
  }

  // Print the map (for debugging or visualization)
  public void printMap() {
    for (int[] row : heightMap) {
      for (int height : row) {
        System.out.print(height + " ");
      }
      System.out.println();
    }
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }
}
