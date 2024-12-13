package com.adventofcode.year2024.day13;

public class Prize {

  private final int xPosition;
  private final int yPosition;

  public Prize(int xPosition, int yPosition) {
      this.xPosition = xPosition;
      this.yPosition = yPosition;
  }

  public int getXPosition() {
    return xPosition;
  }

  public int getYPosition() {
    return yPosition;
  }
}
