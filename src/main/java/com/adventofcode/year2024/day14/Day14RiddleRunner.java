package com.adventofcode.year2024.day14;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.List;

public class Day14RiddleRunner {

  public static void main(String[] args) {
    Day14RiddleSolver riddleSolver = new Day14RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    int gridWidth = 101;
    int gridHeight = 103;

    List<String> input =fileReader.readFile("src/main/resources/2024/14.txt");

    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input, gridWidth, gridHeight));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input, gridWidth, gridHeight));
  }
}
