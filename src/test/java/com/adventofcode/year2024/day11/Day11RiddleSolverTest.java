package com.adventofcode.year2024.day11;

import com.adventofcode.common.AdventOfCodeFileReader;
import com.adventofcode.year2024.day10.Day10RiddleSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11RiddleSolverTest {
  Day11RiddleSolver riddleSolver = new Day11RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void testSolveRiddleOne() {
    int result = riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/11.txt"));
    assertEquals(55312, result);
  }

  @Test
  void testSolveRiddleTwo() {
    int result = riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/11.txt"));
    assertEquals(81, result);
  }
}
