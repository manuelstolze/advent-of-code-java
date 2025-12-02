package com.adventofcode.year2024.day06;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class Day06RiddleRunner {

  public static void main(String[] args) {
    Day06RiddleSolver riddle = new Day06RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input = fileReader.readFile("src/main/resources/2024/06.txt");

    System.out.println("Answer One: " + riddle.solveRiddleOne(input));
    System.out.println("Answer Two: " + riddle.solveRiddleTwo(input));
  }
}
