package com.adventofcode.year2024.day13;

import java.util.List;

public class PlayHall {
  List<ClawMachine> machines;

  public PlayHall(List<ClawMachine> machines) {
      this.machines = machines;
  }

  public int calculateMinimumTokens(){
    int totalTokens = 0;

    for (ClawMachine machine : machines) {
      int tokens = machine.calculateMinimumTokens();
      if (tokens != -1){
        totalTokens += tokens;
      }
    }

    return totalTokens;
  }

  public int countWinnablePrizes(){
    int count = 0;

    for (ClawMachine machine : machines) {
      if (machine.calculateMinimumTokens() != -1){
        count++;
      }
    }
    return count;
  }
}
