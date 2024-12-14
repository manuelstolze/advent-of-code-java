package com.adventofcode.year2024.day14;

import com.adventofcode.common.resolver.AbstractRiddleSolver;
import com.adventofcode.year2024.day12.FenceCalculator;

import java.util.ArrayList;
import java.util.List;

public class Day14RiddleSolver {

  public int solveRiddleOne(List<String> input, int width, int height) {

    int simulationTime = 100;

    List<Robot> robots = parseRobots(input);

    RoboterGrid grid = new RoboterGrid(width, height);
    grid.addRobots(robots);
    grid.simulate(simulationTime,999);

    grid.printGrid();

    int[] quadrantCounts = QuadrantCounter.countInQuadrants(robots, width, height);

    return QuadrantCounter.calculateSafetyFactor(quadrantCounts);
  }

  public int solveRiddleTwo(List<String> input, int width, int height) {
    int simulationTime = 60000;

    List<Robot> robots = parseRobots(input);

    RoboterGrid grid = new RoboterGrid(width, height);
    grid.addRobots(robots);
    grid.simulate(simulationTime, 5);

    //grid.printGrid();
    grid.printResults();

    int[] quadrantCounts = QuadrantCounter.countInQuadrants(robots, width, height);
    return QuadrantCounter.calculateSafetyFactor(quadrantCounts);
  }

  private List<Robot> parseRobots(List<String> input) {
    List<Robot> robots = new ArrayList<>();
    for (String line : input) {
      String[] parts = line.split(" ");
      String[] posParts = parts[0].substring(2).split(",");
      String[] velParts = parts[1].substring(2).split(",");

      int posX = Integer.parseInt(posParts[0]);
      int posY = Integer.parseInt(posParts[1]);
      int velX = Integer.parseInt(velParts[0]);
      int velY = Integer.parseInt(velParts[1]);

      Position position = new Position(posX, posY);
      Velocity velocity = new Velocity(velX, velY);
      robots.add(new Robot(position, velocity));
    }
    return robots;
  }

}
