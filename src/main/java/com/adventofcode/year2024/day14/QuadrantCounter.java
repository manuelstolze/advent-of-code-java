package com.adventofcode.year2024.day14;

import java.util.List;

public class QuadrantCounter {

  public static int[] countInQuadrants(List<Robot> robots, int width, int height){
    int[] quadrantCounts = new int[4];

    int midX = width / 2;
    int midY = height / 2;

    for (Robot robot: robots){
      Position position = robot.getPosition();
      int x = position.getX();
      int y = position.getY();

      // Exclude robots on the middle lines
      if (x == midX || y == midY){
        continue;
      }

      if(x > midX && y < midY) {
        quadrantCounts[0]++; // Q1: Top-right
      } else if (x < midX && y < midY) {
        quadrantCounts[1]++; // Q2: Top-left
      } else if (x < midX && y > midY) {
        quadrantCounts[2]++; // Q3: Bottom-left
      } else if (x > midX && y > midY) {
        quadrantCounts[3]++; // Q4: Bottom-right
      }
    }
    return quadrantCounts;
  }

  public static int calculateSafetyFactor(int[] quadrantCounts) {
    int safetyFactor = 1;
    for (int count : quadrantCounts) {
      safetyFactor *= count;
    }
    return safetyFactor;
  }
}
