package com.adventofcode.year2024.day05;

import com.adventofcode.year2024.day05.record.Day05Input;

public class Day05RiddleRunner {

  public static void main(String[] args) {
    Day05RiddleSolver riddle = new Day05RiddleSolver();
    Day05FileReader fileReader = new Day05FileReader();

    fileReader.readFile("src/main/resources/2024/05.txt");
    Day05Input input =
        new Day05Input(fileReader.getPageOrderingRules(), fileReader.getPageUpdates());

    System.out.println("Answer One: " + riddle.solveRiddleOne(input));
    System.out.println("Answer Two: " + riddle.solveRiddleTwo(input));
  }
}
