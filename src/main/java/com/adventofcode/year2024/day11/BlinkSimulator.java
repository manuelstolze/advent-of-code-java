package com.adventofcode.year2024.day11;

import java.util.List;

public class BlinkSimulator {
  private final StoneLine stoneLine;
  private final int blinkCount;

  public BlinkSimulator(List<Long> initialNumbers, int blinkCount) {
    this.stoneLine = new StoneLine(initialNumbers);;
    this.blinkCount = blinkCount;
  }

  public void simulateBlink() {
    for (int i = 0; i < blinkCount; i++) {
      stoneLine.transform();
    }
  }

  int getStoneCount() {
    return stoneLine.getCount();
  }
}
