package com.adventofcode.year2024.day12;

import java.util.*;

public class GardenMap {
  private GardenPlot[][] map;
  private List<Region> regions;

  // Constructor to initialize the garden map
  public GardenMap(List<String> inputMap) {
    int rows = inputMap.size();
    int cols = inputMap.get(0).length();
    map = new GardenPlot[rows][cols];
    regions = new ArrayList<>();

    // Initialize the GardenPlot objects from the input
    for (int i = 0; i < rows; i++) {
      String row = inputMap.get(i);
      for (int j = 0; j < cols; j++) {
        map[i][j] = new GardenPlot(row.charAt(j), i, j);
      }
    }
  }

  // Detect all regions in the garden
  public void detectRegions() {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        GardenPlot plot = map[i][j];
        if (!plot.isVisited()) {
          Region region = exploreRegion(plot);
          regions.add(region);
        }
      }
    }
  }

  public void detectRegionsWithSides(){
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        GardenPlot plot = map[i][j];
        if (!plot.isVisited()) {
          Region region = exploreRegionWithSides(plot);
          regions.add(region);
        }
      }
    }
  }

  // Explore a region starting from a given plot (using BFS)
  private Region exploreRegion(GardenPlot startPlot) {
    char plantType = startPlot.getPlantType();
    Region region = new Region(plantType);

    Queue<GardenPlot> queue = new LinkedList<>();
    queue.add(startPlot);
    startPlot.setVisited(true);

    while (!queue.isEmpty()) {
      GardenPlot current = queue.poll();
      region.addPlot(current);

      // Check all 4 neighbors
      for (int[] direction : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
        int newX = current.getX() + direction[0];
        int newY = current.getY() + direction[1];

        if (isInBounds(newX, newY)) {
          GardenPlot neighbor = map[newX][newY];
          if (!neighbor.isVisited() && neighbor.getPlantType() == plantType) {
            neighbor.setVisited(true);
            queue.add(neighbor);
          } else if (neighbor.getPlantType() != plantType) {
            // Increment perimeter for edges between regions
            region.incrementPerimeter();
          }
        } else {
          // Increment perimeter for edges at the boundary of the map
          region.incrementPerimeter();
        }
      }
    }

    return region;
  }

  // Explore a region starting from a given plot (using DFS)
  private Region exploreRegionWithSides(GardenPlot startPlot){
    char plantType = startPlot.getPlantType();
    Region region = new Region(plantType);

    Queue<GardenPlot> queue = new LinkedList<>();
    queue.add(startPlot);
    startPlot.setVisited(true);

    while (!queue.isEmpty()) {
      GardenPlot current = queue.poll();
      region.addPlot(current);

      // Check all 4 neighbors
      for (int[] direction : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
        int newX = current.getX() + direction[0];
        int newY = current.getY() + direction[1];

        if (isInBounds(newX, newY)) {
          GardenPlot neighbor = map[newX][newY];
          if (!neighbor.isVisited() && neighbor.getPlantType() == plantType) {
            neighbor.setVisited(true);
            queue.add(neighbor);
          } else if (neighbor.getPlantType() != plantType) {
            region.addSide();
          }
        } else {
          region.addSide();
        }
      }
    }

    return region;
  }

  private boolean isInBounds(int x, int y) {
    return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
  }

  public int calculateTotalFencePrice() {
    int totalPrice = 0;
    for (Region region : regions) {
      totalPrice += region.calculateFenceCost();
    }
    return totalPrice;
  }

  public int calculateTotalFencePriceWithSides() {
    int totalPrice = 0;
    for (Region region : regions) {
      totalPrice += region.calculateFenceCostWithSides();
    }
    return totalPrice;
  }
}
