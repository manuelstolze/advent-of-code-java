package com.adventofcode.year2024.day04;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class Day04RiddleRunner {

  public static void main(String[] args) {
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
    Day04Riddle riddle = new Day04Riddle();

    List<String> lines = fileReader.readFile("src/main/resources/2024/04.txt");

    System.out.println("Answer One: " + riddle.solveRiddleOne(lines));
    System.out.println("Answer Two: " + riddle.solveRiddleTwo(lines));
  }
}
