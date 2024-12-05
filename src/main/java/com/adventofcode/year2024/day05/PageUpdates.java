package com.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.List;

public class PageUpdates {
  private final List<List<Integer>> updates;

  public PageUpdates() {
    updates = new ArrayList<>();
  }

  public void addUpdate(List<Integer> update) {
    updates.add(update);
  }

  public List<List<Integer>> getUpdates() {
    return updates;
  }
}