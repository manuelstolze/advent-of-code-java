package com.adventofcode.year2024.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.common.AdventOfCodeFileReader;
import org.junit.jupiter.api.Test;

public class Day10RiddleSolverTest {
  Day10RiddleSolver riddleSolver = new Day10RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void testSolveRiddleOne() {
    int result = riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/10.txt"));
    assertEquals(36, result);
  }

  @Test
  void testSolveRiddleTwo() {
    int result = riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/10.txt"));
    assertEquals(81, result);
  }
}
