package com.adventofcode.year2024.day09;

import java.util.ArrayList;
import java.util.List;

public class DiskParser {

  public static List<Integer> parseDiskMap(String diskMap) {
    List<Integer> lengths = new ArrayList<>();
    for (char c : diskMap.toCharArray()) {
      lengths.add(Character.getNumericValue(c));
    }
    return lengths;
  }
}
