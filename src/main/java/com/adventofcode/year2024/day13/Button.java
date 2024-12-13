package com.adventofcode.year2024.day13;

public class Button {

  private final int xDelta;
  private final int yDelta;
  private final int cost;

  public Button(int xDelta, int yDelta, int cost) {
      this.xDelta = xDelta;
      this.yDelta = yDelta;
      this.cost = cost;
  }

  public int getXDelta() {
    return xDelta;
  }

  public int getYDelta() {
    return yDelta;
  }

  public int getCost() {
    return cost;
  }
}
