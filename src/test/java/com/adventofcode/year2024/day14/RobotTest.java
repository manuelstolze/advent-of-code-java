package com.adventofcode.year2024.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

  @Test
  void updateRobotPositionInBoundary(){
    Robot robot = new Robot(new Position(2,3), new Velocity(-1, 6));
    robot.move(20, 20);

    assertEquals(1, robot.getPosition().getX());
    assertEquals(9, robot.getPosition().getY());
  }

  @Test
  void updateRobotPositionNotInBoundary(){
    Robot robot = new Robot(new Position(2,3), new Velocity(-3, 19));
    robot.move(20, 20);

    assertEquals(19, robot.getPosition().getX());
    assertEquals(2, robot.getPosition().getY());
  }
}
