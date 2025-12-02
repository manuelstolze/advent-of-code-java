package com.adventofcode.year2024.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.common.AdventOfCodeFileReader;
import org.junit.jupiter.api.Test;

public class Day12RiddleSolverTest {
  Day12RiddleSolver riddleSolver = new Day12RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void testSolveRiddleOne() {
    int result = riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/12.txt"));
    assertEquals(1930, result);
  }

  @Test
  void testSolveRiddleTwo() {
    int result = riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/12.txt"));
    assertEquals(1206, result);
  }
}
