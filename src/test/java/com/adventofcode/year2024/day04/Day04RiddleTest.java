package com.adventofcode.year2024.day04;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day04RiddleTest {

  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
  Day04Riddle riddle = new Day04Riddle();

  @Test
  void testSolveRiddleOne() {

    List<String> lines = fileReader.readFile("src/test/resources/2024/04.txt");

    int result = riddle.solveRiddleOne(lines);
    assertThat(result).isEqualTo(18);
  }

  @Test
  void testSolveRiddleTwo() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/04.txt");

    int result = riddle.solveRiddleTwo(lines);
    assertThat(result).isEqualTo(9);
  }
}
