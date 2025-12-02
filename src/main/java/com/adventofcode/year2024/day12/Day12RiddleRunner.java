package com.adventofcode.year2024.day12;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class Day12RiddleRunner {

  public static void main(String[] args) {
    Day12RiddleSolver riddleSolver = new Day12RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input = fileReader.readFile("src/main/resources/2024/12.txt");

    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input));
  }
}
