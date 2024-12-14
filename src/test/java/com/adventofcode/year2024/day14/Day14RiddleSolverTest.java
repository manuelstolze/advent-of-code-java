package com.adventofcode.year2024.day14;

import com.adventofcode.common.AdventOfCodeFileReader;
import com.adventofcode.year2024.day13.Button;
import com.adventofcode.year2024.day13.ClawMachine;
import com.adventofcode.year2024.day13.Day13RiddleSolver;
import com.adventofcode.year2024.day13.Prize;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14RiddleSolverTest {
  Day14RiddleSolver riddleSolver = new Day14RiddleSolver();
  AdventOfCodeFileReader reader = new AdventOfCodeFileReader();

  @Test
  void testSolveRiddleOne() {
    int gridWidth = 11;
    int gridHeight = 7;

    int result = riddleSolver.solveRiddleOne(reader.readFile("src/test/resources/2024/14.txt"), gridWidth, gridHeight);
    assertEquals(12, result);
  }

  @Test
  void testSolveRiddleTwo() {
    int gridWidth = 11;
    int gridHeight = 7;

    int result = riddleSolver.solveRiddleTwo(reader.readFile("src/test/resources/2024/14.txt"), gridWidth, gridHeight);
    assertEquals(1206, result);
  }
}
