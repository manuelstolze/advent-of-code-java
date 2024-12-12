package com.adventofcode.year2024.day12;

import com.adventofcode.common.resolver.AbstractRiddleSolver;

import java.util.List;

public class Day12RiddleSolver extends AbstractRiddleSolver<List<String>> {

  public int solveRiddleOne(List<String> input) {
    return FenceCalculator.calculateTotalFenceCostWithPerimeter(input);
  }

  public int solveRiddleTwo(List<String> input) {
    // TODO: Currently it does not work properly
    //return FenceCalculator.calculateTotalFenceCostWithSides(input);
    return -1;
  }
}
