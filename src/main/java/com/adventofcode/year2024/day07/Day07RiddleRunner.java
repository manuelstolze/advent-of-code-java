package com.adventofcode.year2024.day07;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class Day07RiddleRunner {

  public static void main(String[] args) {
    Day07RiddleSolver riddle = new Day07RiddleSolver();
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

    List<String> input = fileReader.readFile("src/main/resources/2024/07.txt");

    System.out.println("Answer One: " + riddle.solveRiddleOne(input));
    System.out.println("Answer Two: " + riddle.solveRiddleTwo(input));
  }
}
