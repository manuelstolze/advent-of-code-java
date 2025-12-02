package com.adventofcode.year2024.day12;

import java.util.ArrayList;
import java.util.List;

public class Region {
  List<GardenPlot> plots;
  private final char plantType;
  private int area;
  private int perimeter;
  private int sides;

  public Region(char plantType) {
    this.plots = new ArrayList<>();
    this.plantType = plantType;
    this.area = 0;
    this.perimeter = 0;
  }

  public void addPlot(GardenPlot plot) {
    this.plots.add(plot);
    area++;
  }

  public void addSide() {
    sides++;
  }

  public void incrementPerimeter() {
    perimeter++;
  }

  public int calculateFenceCost() {
    return area * perimeter;
  }

  public int calculateFenceCostWithSides() {
    return area * sides;
  }

  @Override
  public String toString() {
    return "Region{"
        + "plantType="
        + plantType
        + ", area="
        + area
        + ", perimeter="
        + perimeter
        + '}';
  }
}
