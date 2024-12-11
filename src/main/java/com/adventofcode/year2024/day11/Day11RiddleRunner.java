package com.adventofcode.year2024.day11;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.List;

public class Day11RiddleRunner {

  public static void main(String[] args) {
    Day11RiddleSolver riddleSolver = new Day11RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input =fileReader.readFile("src/main/resources/2024/11.txt");

    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input));
  }
}
