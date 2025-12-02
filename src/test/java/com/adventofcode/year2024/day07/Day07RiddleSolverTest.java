package com.adventofcode.year2024.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.common.AdventOfCodeFileReader;
import org.junit.jupiter.api.Test;

public class Day07RiddleSolverTest {

  Day07RiddleSolver riddleSolver = new Day07RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void solveRiddleOne() {
    Long result =
        riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/07.txt"));
    assertEquals(3749, result);
  }

  @Test
  void solveRiddleTwo() {
    Long result =
        riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/07.txt"));
    assertEquals(11387, result);
  }
}
