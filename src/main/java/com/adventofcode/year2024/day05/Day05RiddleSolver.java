package com.adventofcode.year2024.day05;

import com.adventofcode.common.resolver.AbstractRiddleSolver;
import com.adventofcode.year2024.day05.record.Day05Input;

import java.util.List;

public class Day05RiddleSolver extends AbstractRiddleSolver<Day05Input> {
  PageOrderValidator pageOrderValidator = new PageOrderValidator();

  @Override
  public int solveRiddleOne(Day05Input input) {
    int count = 0;
    for (List<Integer> update : input.pageUpdates().getUpdates()) {
      if (pageOrderValidator.isValidUpdate(update, input.pageOrderingRules())) {
        count+= getMiddleElement(update);
      }
    }
    return count;
  }

  @Override
  public int solveRiddleTwo(Day05Input input) {
    int count = 0;

    PageUpdates correctPageUpdates = pageOrderValidator.getCorrectedUpdates(input.pageUpdates().getUpdates(), input.pageOrderingRules());
    for (List<Integer> update : correctPageUpdates.getUpdates()) {
      if (pageOrderValidator.isValidUpdate(update, input.pageOrderingRules())) {
        count+= getMiddleElement(update);
      }
    }
    return count;
  }

  public Integer getMiddleElement(List<Integer> list) {
    if (list.isEmpty()) {
      return null;
    }
    int middleIndex = list.size() / 2;
    if (list.size() % 2 == 0) {
      // List has an even number of elements, choose how to handle this case.
      // This example returns the lower middle element.
      middleIndex--;
    }
    return list.get(middleIndex);
  }
}
