package com.adventofcode.year2024.day08;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.List;

public class Day08RiddleRunner {

  public static void main(String[] args) {
    Day08RiddleSolver riddleSolver = new Day08RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input =fileReader.readFile("src/main/resources/2024/08.txt");

    System.out.println("Day 08 riddle solver: ");
    System.out.println("First riddle solution: " + riddleSolver.solveRiddleOne(input));
    System.out.println("Second riddle solution: " + riddleSolver.solveRiddleTwo(input));
  }
}
