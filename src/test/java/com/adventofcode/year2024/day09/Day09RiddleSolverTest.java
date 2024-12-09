package com.adventofcode.year2024.day09;

import com.adventofcode.common.AdventOfCodeFileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09RiddleSolverTest {
  Day09RiddleSolver riddleSolver = new Day09RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void testSolveRiddleOne() {
    Long result = riddleSolver.solveRiddleOne(fileReader.readFile("src/test/resources/2024/09.txt"));
    assertEquals(1928, result);
  }

  @Test
  void testSolveRiddleTwo() {
    Long result = riddleSolver.solveRiddleTwo(fileReader.readFile("src/test/resources/2024/09.txt"));
    assertEquals(2858, result);
  }

  ;
}
