package com.adventofcode.year2024.day09;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskParserTest {

  @Test
  void testParseDisk() {
    String diskMap = "23331";
    List<Integer> lengths = DiskParser.parseDiskMap(diskMap);

    assertEquals(5, lengths.size());
    assertEquals(new ArrayList<>(List.of(2, 3, 3, 3, 1)), lengths);
  }
}
