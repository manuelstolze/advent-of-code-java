package com.adventofcode.year2024.day11;

import java.util.ArrayList;
import java.util.List;

public class StoneLine {
  List<Stone> stones;

  public StoneLine(List<Long> initialNumbers) {
    this.stones = new ArrayList<>();

    for (Long number: initialNumbers) {
      stones.add(new Stone(number));
    }
  }

  void transform(){
    List<Stone> newStones = new ArrayList<>();
    for (Stone stone : stones) {
      newStones.addAll(stone.transform());
    }
    stones = newStones;
  }

  int getCount(){
    return stones.size();
  }
}
