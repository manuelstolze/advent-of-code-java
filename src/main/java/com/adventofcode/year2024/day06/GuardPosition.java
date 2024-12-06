package com.adventofcode.year2024.day06;

public class GuardPosition {
    private int x;
    private int y;
    private GuardDirection direction;

    public GuardPosition(int x, int y, GuardDirection direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GuardDirection getDirection() {
    return direction;
  }

    public void setDirection(GuardDirection direction) {
    this.direction = direction;
    }

  public void moveForward() {
    switch (this.direction) {
      case UP -> this.x--;
      case DOWN -> this.x++;
      case LEFT -> this.y--;
      case RIGHT -> this.y++;
    }
  }

  public void turnRight() {
    switch (this.direction) {
      case GuardDirection.UP -> setDirection( GuardDirection.RIGHT);
      case GuardDirection.DOWN -> setDirection(GuardDirection.LEFT);
      case GuardDirection.LEFT -> setDirection(GuardDirection.UP);
      case GuardDirection.RIGHT -> setDirection(GuardDirection.DOWN);
    }
  }
}
