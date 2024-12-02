package com.adventofcode.year2024.day02;

import java.util.List;

public class ReportChecker {

  public static boolean isIncreasing(List<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      int diff = list.get(i + 1) - list.get(i);
      if (diff < 1 || diff > 3) {
        return false;
      }
    }
    return true;
  }

  public static boolean isDecreasing(List<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      int diff = list.get(i) - list.get(i + 1);
      if (diff < 1 || diff > 3) {
        return false;
      }
    }
    return true;
  }

  public static boolean isIncreasingOrDecreasing(List<Integer> list) {
    return isIncreasing(list) || isDecreasing(list);
  }
}
