package com.adventofcode.year2024.day02;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.List;

public class RiddleRunner {

  public static void main(String[] args) {
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
    Day02Riddle day02Riddle = new Day02Riddle();

    List<String> lines = fileReader.readFile("src/main/resources/2024/02.txt");

    System.out.println("Answer One: " + day02Riddle.solveRiddleOne(lines));
    System.out.println("Answer Two: " + day02Riddle.solveRiddleTwo(lines));
  }
}
