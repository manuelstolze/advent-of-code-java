package com.adventofcode.year2024.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuardPatrolDevice {

  private char[][] map;
  private Guard guard;
  private final Set<String> visitedPositions = new HashSet<>();

  public GuardPatrolDevice(List<String> input) {
    this.map = this.convertStringListToGrid(input);
    this.guard = this.addGuard();
  }

  public void simulatePatrol(){
    boolean breaker = false;

    while(isWithinBounds(guard.getPosition()) && !breaker){
      try {
        visitedPositions.add(guard.getPosition().getX() + "," + guard.getPosition().getY());

        int x = guard.getPosition().getX();
        int y = guard.getPosition().getY();
        switch (guard.getPosition().getDirection()) {
          case UP -> x--;
          case DOWN -> x++;
          case LEFT -> y--;
          case RIGHT -> y++;
        }

        if (!isWithinBounds(new GuardPosition(x, y, guard.getPosition().getDirection()))){
          break;
        }


        if (isObstacleInFront()) {
          guard.getPosition().turnRight();
        } else {
          guard.getPosition().moveForward();
          this.map[guard.getPosition().getX()][guard.getPosition().getY()] = 'D';
        }
      } catch (IndexOutOfBoundsException e) {
        breaker = true;
      }
    }
  }

  private boolean isWithinBounds(GuardPosition position){
    return position.getX() >= 0 && position.getX() < map[0].length &&
            position.getY() >= 0 && position.getY() < map.length; }

  private boolean isObstacleInFront() {
    int x = guard.getPosition().getX();
    int y = guard.getPosition().getY();
    switch (guard.getPosition().getDirection()) {
      case UP -> x--;
      case DOWN -> x++;
      case LEFT -> y--;
      case RIGHT -> y++;
    }

    return x >= map[0].length || y >= map.length || map[x][y] == '#';
  }

  public char[][] convertStringListToGrid(List<String> input){
    char[][] grid = new char[input.size()][input.get(0).length()];
    for (int row = 0; row < input.size(); row++) {
      for (int col = 0; col < input.get(row).length(); col++) {
        grid[row][col] = input.get(row).charAt(col);
      }
    }
    return grid;
  }

  public Set<String> getVisitedPositions() {
    return visitedPositions;
  }

  public Guard getGuard(){
    return this.guard;
  }

  public char[][] getMap(){
    return this.map;
  }

  public GuardPosition getCurrentGuardPosition(){
      for (int row = 0; row < this.map.length; row++) {
      for (int col = 0; col < this.map[row].length; col++) {
          if(this.map[row][col] == '^' || this.map[row][col] == 'v' || this.map[row][col] == '<' || this.map[row][col] == '>'){
            GuardDirection direction = GuardDirection.getDirectionByChar(this.map[row][col]);
            return new GuardPosition(row, col, direction);
          }
        }
      }
      throw new RuntimeException("No guard found");
  }

  private Guard addGuard(){
    GuardPosition position = getCurrentGuardPosition();
    return new Guard(position);
  }
}
