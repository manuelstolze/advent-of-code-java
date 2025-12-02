package com.adventofcode.year2024.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day08RiddleSolverTest {

  Day08RiddleSolver riddleSolver = new Day08RiddleSolver();
  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  @Test
  void solveRiddleOne() {
    List<String> input = fileReader.readFile("src/test/resources/2024/08.txt");
    int result = riddleSolver.solveRiddleOne(input);
    assertEquals(14, result);
  }

  @Test
  void solveRiddleTwo() {
    List<String> input = fileReader.readFile("src/test/resources/2024/08.txt");
    int result = riddleSolver.solveRiddleTwo(input);
    assertEquals(34, result);
  }
}
