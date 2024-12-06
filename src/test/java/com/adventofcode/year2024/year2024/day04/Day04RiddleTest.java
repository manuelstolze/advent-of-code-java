package com.adventofcode.year2024.year2024.day04;

import com.adventofcode.common.AdventOfCodeFileReader;
import com.adventofcode.year2024.day04.Day04Riddle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
