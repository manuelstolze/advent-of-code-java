package com.adventofcode.year2024.day12;

public class GardenPlot {
  private final char plantType;
  private final int x;
  private final int y;
  private boolean visited;

  public GardenPlot(char plantType, int x, int y) {
    this.plantType = plantType;
    this.visited = false;
    this.x = x;
    this.y = y;
  }

  public char getPlantType() {
      return plantType;
  }

  public int getX() {
      return x;
  }

  public int getY() {
      return y;
  }

  public boolean isVisited() {
      return visited;
  }

  public void setVisited(boolean visited) {
      this.visited = visited;
  }

  @Override
  public String toString() {
    return "GardenPlot{" +
            "plantType=" + plantType +
            ", visited=" + visited +
            ", x=" + x +
            ", y=" + y +
            '}';
  }
}
