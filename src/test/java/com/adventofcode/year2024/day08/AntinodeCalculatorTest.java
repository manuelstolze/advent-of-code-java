package com.adventofcode.year2024.day08;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AntinodeCalculatorTest {

  @Test
  public void testCalculateAntinodes() {
    List<String> map = List.of(
        ".......",
        ".......",
        "..a.b..",
        ".......",
        "..b.a..",
        ".......",
        "......."
    );
    Set<String> expectedAntinodes = Set.of("6,6", "0,0", "0,6", "6,0");
    AntinodeCalculator calculator = new AntinodeCalculator(map);

    // Act
    Set<String> actualAntinodes = calculator.calculateAntinodes();

    // Assert
    assertEquals(expectedAntinodes, actualAntinodes);
  }

}
