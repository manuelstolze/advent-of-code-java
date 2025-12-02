package com.adventofcode.year2024.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adventofcode.year2024.day05.record.Day05Input;
import org.junit.jupiter.api.Test;

public class Day05RiddleSolverTest {
  Day05FileReader fileReader = new Day05FileReader();
  Day05RiddleSolver riddle = new Day05RiddleSolver();

  @Test
  void solveRiddleOne() {
    fileReader.readFile("src/test/resources/2024/05.txt");

    PageOrderingRules pageOrderingRules = fileReader.getPageOrderingRules();
    PageUpdates pageUpdates = fileReader.getPageUpdates();

    int result = riddle.solveRiddleOne(new Day05Input(pageOrderingRules, pageUpdates));
    assertEquals(143, result);
  }

  @Test
  void solveRiddleRow() {
    fileReader.readFile("src/test/resources/2024/05.txt");

    PageOrderingRules pageOrderingRules = fileReader.getPageOrderingRules();
    PageUpdates pageUpdates = fileReader.getPageUpdates();

    int result = riddle.solveRiddleTwo(new Day05Input(pageOrderingRules, pageUpdates));
    assertEquals(123, result);
  }
}
