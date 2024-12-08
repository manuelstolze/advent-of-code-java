package com.adventofcode.year2024.day08;

import com.adventofcode.common.resolver.AbstractRiddleSolver;

import java.util.List;
import java.util.Set;

public class Day08RiddleSolver extends AbstractRiddleSolver<List<String>> {
  @Override
  public int solveRiddleOne(List<String> input) {
    AntinodeCalculator antinodeCalculator = new AntinodeCalculator(input);
    Set<String> antinodes = antinodeCalculator.calculateAntinodes();

    return antinodes.size();
  }

  @Override
  public int solveRiddleTwo(List<String> input) {
    AntinodeCalculator antinodeCalculator = new AntinodeCalculator(input);
    Set<String> antinodes = antinodeCalculator.calculateAntinodesWithHarmonicResonance();

    return antinodes.size();
  }
}
