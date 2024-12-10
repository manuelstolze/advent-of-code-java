package com.adventofcode.year2024.day10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HikingTrail {
  final int TARGET_HEIGHT = 9;

  // BFS to get all trails
  public int exploreTrailsFrom(int startX, int startY, TopographicMap map){
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[map.getRows()][map.getColumns()];
    int numberOfReachableTops = 0;


    queue.add(new int[]{startX, startY});

    visited[startX][startY] = true;

    while (!queue.isEmpty()){
      int [] current = queue.poll();
      int x = current[0];
      int y = current[1];

      int currentHeight = map.getHeightAt(x, y);

      if (currentHeight == TARGET_HEIGHT) {
        numberOfReachableTops++;
        continue;
      }

      for (int[] direction: getDirections()){
        int newX = x + direction[0];
        int newY = y + direction[1];

        if (map.isValidPosition(newX, newY) && !visited[newX][newY]){
          int nextHeight = map.getHeightAt(newX, newY);

          if (nextHeight == currentHeight +1){
            queue.add(new int[]{newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
    }
    return  numberOfReachableTops;
  }

  public int exploreDistinctTrailsFrom(int startX, int startY, TopographicMap map) {
    return dfsCountTrails(startX, startY, map, new boolean[map.getRows()][map.getColumns()]);
  }

  // Recursive DFS to count distinct trails
  private int dfsCountTrails(int x, int y, TopographicMap map, boolean[][] visited) {
    int currentHeight = map.getHeightAt(x, y);
    if (currentHeight == TARGET_HEIGHT) {
      return 1; // Reached a 9, count this trail
    }

    visited[x][y] = true;
    int distinctTrails = 0;

    for (int[] direction : getDirections()) {
      int newX = x + direction[0];
      int newY = y + direction[1];

      if (map.isValidPosition(newX, newY) && !visited[newX][newY]) {
        int nextHeight = map.getHeightAt(newX, newY);
        if (nextHeight == currentHeight + 1) {
          distinctTrails += dfsCountTrails(newX, newY, map, visited);
        }
      }
    }

    visited[x][y] = false; // Backtrack
    return distinctTrails;
  }

  private List<int[]> getDirections() {
    return Arrays.asList(
            new int[]{-1, 0}, // Up
            new int[]{1, 0},  // Down
            new int[]{0, -1}, // Left
            new int[]{0, 1}   // Right
    );
  }
}
