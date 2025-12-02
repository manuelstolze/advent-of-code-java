package com.adventofcode.year2024.day05;

import java.util.*;

public class PageOrderValidator {

  public boolean isValidUpdate(List<Integer> update, PageOrderingRules rules) {
    Map<Integer, Integer> positionMap = new HashMap<>();

    for (int i = 0; i < update.size(); i++) {
      positionMap.put(update.get(i), i);
    }

    for (Map.Entry<Integer, List<Integer>> entry : rules.getRules().entrySet()) {
      int pageX = entry.getKey();
      List<Integer> pageYs = entry.getValue();

      Integer pageXPosition = positionMap.get(pageX);
      if (pageXPosition == null) continue;

      for (int pageY : pageYs) {
        Integer pageYPosition = positionMap.get(pageY);

        if (pageYPosition != null && pageXPosition > pageYPosition) {
          return false;
        }
      }
    }
    return true;
  }

  public PageUpdates getCorrectedUpdates(List<List<Integer>> updates, PageOrderingRules rules) {
    PageUpdates correctedPageUpdates = new PageUpdates();
    for (List<Integer> update : updates) {
      if (!isValidUpdate(update, rules)) {
        correctedPageUpdates.addUpdate(correctUpdate(update, rules));
      }
    }
    return correctedPageUpdates;
  }

  private List<Integer> correctUpdate(List<Integer> update, PageOrderingRules rules) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();

    for (int page : update) {
      graph.put(page, new ArrayList<>());
      inDegree.put(page, 0);
    }

    for (Map.Entry<Integer, List<Integer>> entry : rules.getRules().entrySet()) {
      int pageX = entry.getKey();
      List<Integer> pageYs = entry.getValue();

      for (int pageY : pageYs) {
        if (graph.containsKey(pageX) && graph.containsKey(pageY)) {
          graph.get(pageX).add(pageY);
          inDegree.put(pageY, inDegree.get(pageY) + 1);
        }
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }

    List<Integer> sortedUpdate = new ArrayList<>();
    while (!queue.isEmpty()) {
      int page = queue.poll();
      sortedUpdate.add(page);

      for (int neighbor : graph.get(page)) {
        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
        if (inDegree.get(neighbor) == 0) {
          queue.add(neighbor);
        }
      }
    }

    return sortedUpdate;
  }
}
