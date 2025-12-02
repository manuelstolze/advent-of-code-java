package com.adventofcode.year2024.day14;

import java.util.*;

public class RoboterGrid {
  private final int width;
  private final int height;
  int[][] grid;
  List<Robot> robots;

  HashMap<Integer, CenterOfMassCalculator.Result> results = new HashMap<>();

  public RoboterGrid(int width, int height) {
    this.width = width;
    this.height = height;
    this.robots = new ArrayList<>();

    this.grid = new int[width][height];
  }

  public void addRobots(List<Robot> robots) {
    this.robots.addAll(robots);
  }

  public void simulate(int seconds, int detectEasterEggLength) {
    for (int i = 0; i < seconds; i++) {
      for (Robot robot : robots) {
        if (grid[robot.getPosition().getX()][robot.getPosition().getY()] > 0) {
          grid[robot.getPosition().getX()][robot.getPosition().getY()]--;
        }
        robot.move(width, height);
        grid[robot.getPosition().getX()][robot.getPosition().getY()]++;
      }

      CenterOfMassCalculator.Result result = CenterOfMassCalculator.findLargestCluster(grid);
      results.put(i, result);
    }
  }

  public void printResults() {

    // Konvertieren der HashMap in eine Liste von Map.Entry
    List<Map.Entry<Integer, CenterOfMassCalculator.Result>> entryList =
        new ArrayList<>(results.entrySet());

    // Sortieren der Liste nach der Größe der Result-Objekte
    entryList.sort(
        (entry1, entry2) -> Integer.compare(entry1.getValue().size, entry2.getValue().size));

    // Ausgabe der sortierten Liste
    System.out.println("Sortierte Result-Objekte nach Größe:");
    for (Map.Entry<Integer, CenterOfMassCalculator.Result> entry : entryList) {
      System.out.println("Second: " + entry.getKey() + ", " + entry.getValue().toString());
    }
  }

  public void printGrid() {

    //    for(int i = 0; i < grid.length; i++){
    //      System.out.println(Arrays.toString(grid[i]));
    //    }

    for (int[] x : grid) {
      char[] charArray = new char[x.length];

      for (int i = 0; i < x.length; i++) {
        if (x[i] == 0) {
          charArray[i] = '.';
          continue;
        }
        charArray[i] = (char) (x[i] + '0'); // Add '0' to convert to character
      }
      System.out.println(Arrays.toString(charArray));
    }
    System.out.println("-------------------------------");
  }
}
