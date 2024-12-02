package com.adventofcode.year2024.day02;

import java.util.ArrayList;
import java.util.List;

public class ProblemDumper {

  public static boolean isSave(List<Integer> list){
    return isIncreasing(list) || isDecreasing(list);
  }

  private static boolean isIncreasing(List<Integer> list) {
    if (ReportChecker.isIncreasing(list)) {
      return true;
    }

    for (int i = 0; i < list.size(); i++) {
      List<Integer> newList = removeElement(list, i);
      if (ReportChecker.isIncreasing(newList)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isDecreasing(List<Integer> list) {
    if (ReportChecker.isDecreasing(list)) {
      return true;
    }

    for (int i = 0; i < list.size(); i++) {
      List<Integer> newList = removeElement(list, i);
      if (ReportChecker.isDecreasing(newList)) {
        return true;
      }
    }
    return false;
  }

  private static List<Integer> removeElement(List<Integer> list, int index) {
    List<Integer> newList = new ArrayList<>(list);
    newList.remove(index);
    return newList;
  }
}
