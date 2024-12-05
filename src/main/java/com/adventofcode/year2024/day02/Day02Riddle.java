package com.adventofcode.year2024.day02;

import com.adventofcode.common.resolver.AbstractRiddleSolver;

import java.util.Arrays;
import java.util.List;

public class Day02Riddle extends AbstractRiddleSolver<List<String>> {

  public Day02Riddle() {}

  @Override
  public int solveRiddleOne(List<String> lines) {
    int numberOfSaveReports = 0;
    for (String line : lines) {
      List<Integer> codes = extractCodeFromReport(line);
      if(ReportChecker.isIncreasingOrDecreasing(codes)){
        numberOfSaveReports++;
      }
    }
    return numberOfSaveReports;
  }

  public int solveRiddleTwo(List<String> lines) {
    int numberOfSaveReports = 0;
    for (String line : lines) {
      List<Integer> codes = extractCodeFromReport(line);
      if(ProblemDumper.isSave(codes)){
        numberOfSaveReports++;
      }
    }
    return numberOfSaveReports;
  }

  public List<Integer> extractCodeFromReport(String report){
    return Arrays.stream(report.split("\\s+"))
            .map(Integer::parseInt)
            .toList();
  }
}
