package com.adventofcode.year2024.day03;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day03RiddleTest {

  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
  Day03Riddle riddle = new Day03Riddle();

  @Test
  void testSolveRiddleOne() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/03.txt");

    int result = riddle.solveRiddleOne(lines);
    assert result == 161;
  }

  @Test
  void testSolveRiddleTwo() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/03_02.txt");

    int result = riddle.solveRiddleTwo(lines);
    assert result == 48;
  }
}
