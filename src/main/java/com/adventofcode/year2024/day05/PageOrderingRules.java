package com.adventofcode.year2024.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageOrderingRules {
  private final Map<Integer, List<Integer>> rules;

  public PageOrderingRules() {
    rules = new HashMap<>();
  }

  public void addRule(int pageX, int pageY) {
    rules.computeIfAbsent(pageX, key -> new ArrayList<>()).add(pageY);
  }

  public Map<Integer, List<Integer>> getRules() {
    return rules;
  }
}
