package com.adventofcode.year2024.day13;

import java.util.List;

public class Day13RiddleSolver {

  public int solveRiddleOne(List<ClawMachine> input) {
    PlayHall playHall = new PlayHall(input);
    int minimumTokens = playHall.calculateMinimumTokens();
    int winnablePrizes = playHall.countWinnablePrizes();

    System.out.println("Total Minimum Tokens: " + minimumTokens);
    System.out.println("Winnable Prizes: " + winnablePrizes);

    return minimumTokens;
  }

  public int solveRiddleTwo(List<ClawMachine> input) {
    return -1;
  }
}
