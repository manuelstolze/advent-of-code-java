package com.adventofcode.year2024.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day13RiddleSolverTest {
  Day13RiddleSolver riddleSolver = new Day13RiddleSolver();

  @Test
  void testSolveRiddleOne() throws IOException {
    int result = riddleSolver.solveRiddleOne(readInputFile("src/test/resources/2024/13.txt"));
    assertEquals(480, result);
  }

  @Test
  void testSolveRiddleTwo() throws IOException {
    int result = riddleSolver.solveRiddleTwo(readInputFile("src/test/resources/2024/13.txt"));
    assertEquals(1206, result);
  }

  public static List<ClawMachine> readInputFile(String fileName) throws IOException {
    List<ClawMachine> machines = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    String line;
    while ((line = reader.readLine()) != null) {
      if (line.trim().isEmpty()) {
        continue; // Skip empty lines
      }

      String buttonALine = line;
      String buttonBLine = reader.readLine();
      String prizeLine = reader.readLine();

      if (buttonBLine == null || prizeLine == null) {
        throw new IOException("Malformed input file");
      }

      // Parse Button A
      String[] buttonAComponents = buttonALine.replace("Button A: ", "").split(", ");
      int xDeltaA = Integer.parseInt(buttonAComponents[0].replace("X+", ""));
      int yDeltaA = Integer.parseInt(buttonAComponents[1].replace("Y+", ""));

      // Parse Button B
      String[] buttonBComponents = buttonBLine.replace("Button B: ", "").split(", ");
      int xDeltaB = Integer.parseInt(buttonBComponents[0].replace("X+", ""));
      int yDeltaB = Integer.parseInt(buttonBComponents[1].replace("Y+", ""));

      // Parse Prize
      String[] prizeComponents = prizeLine.replace("Prize: ", "").split(", ");
      int xPrize = Integer.parseInt(prizeComponents[0].replace("X=", ""));
      int yPrize = Integer.parseInt(prizeComponents[1].replace("Y=", ""));

      // Create objects
      Button buttonA = new Button(xDeltaA, yDeltaA, 3);
      Button buttonB = new Button(xDeltaB, yDeltaB, 1);
      Prize prize = new Prize(xPrize, yPrize);

      machines.add(new ClawMachine(buttonA, buttonB, prize));
    }

    reader.close();
    return machines;
  }
}
