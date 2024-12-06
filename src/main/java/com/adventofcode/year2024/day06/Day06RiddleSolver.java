package com.adventofcode.year2024.day06;

import com.adventofcode.common.resolver.AbstractRiddleSolver;

import java.util.List;
import java.util.Set;

public class Day06RiddleSolver extends AbstractRiddleSolver<List<String>> {
  @Override
  public int solveRiddleOne(List<String> input) {
    GuardPatrolDevice guardPatrolDevice = new GuardPatrolDevice(input);

    guardPatrolDevice.simulatePatrol();
    Set<String> visitedPositions = guardPatrolDevice.getVisitedPositions();
    return visitedPositions.size();
  }

  @Override
  public int solveRiddleTwo(List<String> input) {
    GuardPatrolDevice guardPatrolDevice = new GuardPatrolDevice(input);

    int loopCount = 0;

    return 0;
  }
}
