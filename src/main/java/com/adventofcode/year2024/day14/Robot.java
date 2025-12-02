package com.adventofcode.year2024.day14;

public class Robot {
  private final Position position;
  private final Velocity velocity;

  public Robot(Position position, Velocity velocity) {
    this.position = position;
    this.velocity = velocity;
  }

  public void move(int width, int height) {
    position.updatePosition(velocity, width, height);
  }

  public Position getPosition() {
    return position;
  }
}
