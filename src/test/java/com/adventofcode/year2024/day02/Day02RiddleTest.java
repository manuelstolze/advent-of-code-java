package com.adventofcode.year2024.day02;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day02RiddleTest {

  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
  Day02Riddle day02Riddle = new Day02Riddle();

  @Test
  void testExtractCodeFromReport() {
    String report = "1 2 3 4 5";
    assert day02Riddle.extractCodeFromReport(report).equals(List.of(1, 2, 3, 4, 5));
  }

  @Test
  void testSolveRiddleOne() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/02.txt");

    int numberOfSaveReports = day02Riddle.solveRiddleOne(lines);
    assert numberOfSaveReports == 2;
  }

  @Test
  void testSolveRiddleTwo() {
    List<String> lines = fileReader.readFile("src/test/resources/2024/02.txt");

    int numberOfSaveReports = day02Riddle.solveRiddleTwo(lines);
    assert numberOfSaveReports == 4;
  }
}
