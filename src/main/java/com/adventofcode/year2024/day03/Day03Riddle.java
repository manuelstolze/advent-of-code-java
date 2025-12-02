package com.adventofcode.year2024.day03;

import com.adventofcode.common.resolver.AbstractRiddleSolver;
import java.util.ArrayList;
import java.util.List;

public class Day03Riddle extends AbstractRiddleSolver<List<String>> {

  @Override
  public int solveRiddleOne(List<String> lines) {
    List<List<Integer>> instructions = new ArrayList<>();
    for (String line : lines) {
      instructions.addAll(InstructionExtractor.extract(line));
    }
    return multiplyInstructions(instructions);
  }

  @Override
  public int solveRiddleTwo(List<String> lines) {
    List<List<Integer>> instructions = new ArrayList<>();

    for (String line : lines) {
      instructions.addAll(InstructionExtractor.extractOnlyEnabledInstructions(line));
    }
    return multiplyInstructions(instructions);
  }

  private int multiplyInstructions(List<List<Integer>> instructions) {
    int result = 0;
    for (List<Integer> instruction : instructions) {
      result += instruction.get(0) * instruction.get(1);
    }
    return result;
  }
}
