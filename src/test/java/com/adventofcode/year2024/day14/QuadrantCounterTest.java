package com.adventofcode.year2024.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class QuadrantCounterTest {

  @Test
  void countOneRoboterInEachQuadrant() {
    List<Robot> robots = new ArrayList<>();
    robots.add(new Robot(new Position(0, 0), new Velocity(0, 0)));
    robots.add(new Robot(new Position(4, 4), new Velocity(0, 0)));
    robots.add(new Robot(new Position(0, 4), new Velocity(0, 0)));
    robots.add(new Robot(new Position(4, 0), new Velocity(0, 0)));

    int[] counts = QuadrantCounter.countInQuadrants(robots, 2, 2);

    assertEquals(1, counts[0]);
    assertEquals(1, counts[1]);
    assertEquals(1, counts[2]);
    assertEquals(1, counts[3]);
  }

  @Test
  void countFourRoboterOnSamePosition() {
    List<Robot> robots = new ArrayList<>();
    robots.add(new Robot(new Position(0, 0), new Velocity(0, 0)));
    robots.add(new Robot(new Position(0, 0), new Velocity(0, 0)));
    robots.add(new Robot(new Position(0, 0), new Velocity(0, 0)));
    robots.add(new Robot(new Position(0, 0), new Velocity(0, 0)));

    int[] counts = QuadrantCounter.countInQuadrants(robots, 2, 2);

    assertEquals(0, counts[0]);
    assertEquals(4, counts[1]);
    assertEquals(0, counts[2]);
    assertEquals(0, counts[3]);
  }

  @Test
  void countIgnoreRobotsOnMiddleAxis() {
    List<Robot> robots = new ArrayList<>();
    robots.add(new Robot(new Position(0, 1), new Velocity(0, 0)));
    robots.add(new Robot(new Position(1, 0), new Velocity(0, 0)));

    int[] counts = QuadrantCounter.countInQuadrants(robots, 2, 2);

    assertEquals(0, counts[0]);
    assertEquals(0, counts[1]);
    assertEquals(0, counts[2]);
    assertEquals(0, counts[3]);
  }
}
