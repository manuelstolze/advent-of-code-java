package com.adventofcode.year2024.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GuardDirectionTest {

  @Test
  void getDirectionByChar() {
    GuardDirection up = GuardDirection.getDirectionByChar('^');
    GuardDirection down = GuardDirection.getDirectionByChar('v');
    GuardDirection left = GuardDirection.getDirectionByChar('<');
    GuardDirection right = GuardDirection.getDirectionByChar('>');

    assertEquals(GuardDirection.UP, up);
    assertEquals(GuardDirection.DOWN, down);
    assertEquals(GuardDirection.LEFT, left);
    assertEquals(GuardDirection.RIGHT, right);
  }

  @Test
  void values() {
    GuardDirection[] values = GuardDirection.values();

    assertEquals(4, values.length);
    assertEquals(GuardDirection.UP, values[0]);
    assertEquals(GuardDirection.DOWN, values[1]);
    assertEquals(GuardDirection.LEFT, values[2]);
    assertEquals(GuardDirection.RIGHT, values[3]);
  }
}
