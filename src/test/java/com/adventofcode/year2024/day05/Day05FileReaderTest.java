package com.adventofcode.year2024.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day05FileReaderTest {

  private Day05FileReader fileReader;
  private final String testFilePath = "src/test/resources/2024//customInput/05.txt";

  @BeforeEach
  void setUp() {
    fileReader = new Day05FileReader();
  }

  @Test
  void testGetPageOrderingRules() {
    fileReader.readFile(testFilePath);
    PageOrderingRules expectedPageOrderingRules = new PageOrderingRules();
    expectedPageOrderingRules.addRule(47, 53);
    expectedPageOrderingRules.addRule(97, 13);
    expectedPageOrderingRules.addRule(97, 14);

    PageOrderingRules pageOrderingRules = fileReader.getPageOrderingRules();

    assertEquals(expectedPageOrderingRules.getRules(), pageOrderingRules.getRules());
  }

  @Test
  void testGetPageUpdates() {
    fileReader.readFile(testFilePath);
    PageUpdates expectedPageUpdates = new PageUpdates();
    expectedPageUpdates.addUpdate(List.of(75, 47, 61, 53, 29));
    expectedPageUpdates.addUpdate(List.of(97, 61, 53, 29, 13));

    PageUpdates pageUpdates = fileReader.getPageUpdates();

    assertEquals(expectedPageUpdates.getUpdates(), pageUpdates.getUpdates());
  }
}
