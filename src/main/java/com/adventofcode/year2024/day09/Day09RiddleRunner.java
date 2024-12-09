package com.adventofcode.year2024.day09;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.List;

public class Day09RiddleRunner {

  public static void main(String[] args) {
    Day09RiddleSolver riddleSolver = new Day09RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input =fileReader.readFile("src/main/resources/2024/09.txt");

    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input));
  }
}
