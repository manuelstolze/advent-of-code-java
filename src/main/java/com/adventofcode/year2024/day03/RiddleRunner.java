package com.adventofcode.year2024.day03;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;

public class RiddleRunner {

  public static void main(String[] args) {
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
    Day03Riddle riddle = new Day03Riddle();

    List<String> lines = fileReader.readFile("src/main/resources/2024/03.txt");

    System.out.println("Answer One: " + riddle.solveRiddleOne(lines));
    System.out.println("Answer Two: " + riddle.solveRiddleTwo(lines));
  }
}
