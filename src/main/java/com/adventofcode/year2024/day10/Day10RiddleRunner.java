package com.adventofcode.year2024.day10;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class Day10RiddleRunner {

  public static void main(String[] args) {
    Day10RiddleSolver riddleSolver = new Day10RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input = fileReader.readFile("src/main/resources/2024/10.txt");

    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input));
  }
}
