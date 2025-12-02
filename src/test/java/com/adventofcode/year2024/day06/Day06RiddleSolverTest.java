package com.adventofcode.year2024.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.common.AdventOfCodeFileReader;
import org.junit.jupiter.api.Test;

public class Day06RiddleSolverTest {

  Day06RiddleSolver riddleSolver = new Day06RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void solveRiddleOne() {

    int result = riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/06.txt"));
    assertEquals(41, result);
  }

  @Test
  void solveRiddleRow() {
    int result = riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/06.txt"));
    assertEquals(6, result);
  }
}
