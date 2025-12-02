package com.adventofcode.year2024.day11;

import java.util.*;

public class Day11RiddleSolver {

  public int solveRiddleOne(List<String> input) {
    int blinkCount = 25; // Number of blinks
    List<Long> initialNumbers =
        Arrays.stream(input.get(0).split("\\s+")).map(Long::parseLong).toList();

    BlinkSimulator simulator = new BlinkSimulator(initialNumbers, blinkCount);

    // Run simulation
    simulator.simulateBlink();
    return simulator.getStoneCount();
  }

  public long solveRiddleTwo(List<String> input) {
    List<Long> initialNumbers =
        Arrays.stream(input.get(0).split("\\s+")).map(Long::parseLong).toList();

    Map<Long, Long> stoneCounts = new HashMap<>();
    for (Long number : initialNumbers) {
      stoneCounts.merge(number, 1L, Long::sum);
    }

    int blinkCount = 75; // Number of blinks

    for (int i = 0; i < blinkCount; i++) {
      stoneCounts = transformStones(stoneCounts);
    }

    return stoneCounts.values().stream().mapToLong(Long::longValue).sum();
  }

  private static Map<Long, Long> transformStones(Map<Long, Long> stoneCounts) {
    Map<Long, Long> newCounts = new HashMap<>();

    for (Map.Entry<Long, Long> entry : stoneCounts.entrySet()) {
      long stone = entry.getKey();
      long count = entry.getValue();

      if (stone == 0) {
        newCounts.merge(1L, count, Long::sum);
      } else if (hasEvenDigits(stone)) {
        String numStr = Long.toString(stone);
        int mid = numStr.length() / 2;
        long left = Long.parseLong(numStr.substring(0, mid));
        long right = Long.parseLong(numStr.substring(mid));
        newCounts.merge(left, count, Long::sum);
        newCounts.merge(right, count, Long::sum);
      } else {
        newCounts.merge(stone * 2024, count, Long::sum);
      }
    }

    return newCounts;
  }

  private static boolean hasEvenDigits(long number) {
    return Long.toString(number).length() % 2 == 0;
  }
}
