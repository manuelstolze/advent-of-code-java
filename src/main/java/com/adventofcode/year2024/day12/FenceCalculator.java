package com.adventofcode.year2024.day12;

import java.util.List;

public class FenceCalculator {

  public static int calculateTotalFenceCostWithPerimeter(List<String> gardenMapInput) {
    GardenMap gardenMap = new GardenMap(gardenMapInput);
    gardenMap.detectRegions();

    return gardenMap.calculateTotalFencePrice();
  }

  public static int calculateTotalFenceCostWithSides(List<String> gardenMapInput) {
    GardenMap gardenMap = new GardenMap(gardenMapInput);
    gardenMap.detectRegionsWithSides();

    return gardenMap.calculateTotalFencePriceWithSides();
  }
}
