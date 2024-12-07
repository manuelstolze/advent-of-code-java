package com.adventofcode.year2024.day06;

import com.adventofcode.year2024.day06.GuardPatrolDevice;
import com.adventofcode.year2024.day06.GuardDirection;
import com.adventofcode.year2024.day06.GuardPosition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardAvoidingDeviceTest {

  @Test
  void convertMapToGrid() {
    List<String> input = new ArrayList<>(List.of("##v#", "#.##", "###.", ".###"));
    GuardPatrolDevice guardPatrolDevice = new GuardPatrolDevice(input);

    assertEquals(4, guardPatrolDevice.getMap().length);
    assertEquals(4, guardPatrolDevice.getMap()[0].length);
  }

  @Test
  void getCurrentGuardPosition() {
    List<String> input = new ArrayList<>(List.of("##v#", "#.##", "###.", ".###"));
    GuardPatrolDevice guardPatrolDevice = new GuardPatrolDevice(input);

    char[][] grid = guardPatrolDevice.convertStringListToGrid(input);
    GuardPosition position = guardPatrolDevice.getCurrentGuardPosition();

    assertEquals(0, position.getX());
    assertEquals(2, position.getY());
    assertEquals(GuardDirection.DOWN, position.getDirection());
  }

  @Test
  void simulateWalk() {
    List<String> input = new ArrayList<>(List.of("#.v#", "..##", "###.", ".###"));
    GuardPatrolDevice guardPatrolDevice = new GuardPatrolDevice(input);

    char[][] grid = guardPatrolDevice.convertStringListToGrid(input);
    GuardPosition position = guardPatrolDevice.getCurrentGuardPosition();

    guardPatrolDevice.simulatePatrol();

    assertEquals(3, position.getX());
    assertEquals(2, position.getY());
    assertEquals(GuardDirection.DOWN, position.getDirection());
  }
}
