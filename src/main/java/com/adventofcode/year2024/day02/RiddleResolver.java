package com.adventofcode.year2024.day02;

import com.adventofcode.common.AdventOfCodeFileReader;
import com.adventofcode.common.IRiddleResolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RiddleResolver implements IRiddleResolver {

  AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();

  public RiddleResolver() {}

  public void solveRiddleOne(String[] args) {
    List<String> lines = fileReader.readFile("src/main/resources/2024/02.txt");
    int numberOfSaveReports = 0;

    for (String line : lines) {
      List<Integer> codes = extractCodeFromReport(line);

      if(ReportChecker.isIncreasingOrDecreasing(codes)){
        numberOfSaveReports++;
      }
    }

    System.out.println("Answer One: " + numberOfSaveReports);
  }

  public void solveRiddleTwo(String[] args) {
    List<String> lines = fileReader.readFile("src/main/resources/2024/02.txt");
    int numberOfSaveReports = 0;

    for (String line : lines) {
      List<Integer> codes = extractCodeFromReport(line);

      if(ProblemDumper.isSave(codes)){
        numberOfSaveReports++;
      }
    }
    System.out.println("Answer Two: " + numberOfSaveReports);
  }

  public List<Integer> extractCodeFromReport(String report){
    return Arrays.stream(report.split("\\s+"))
            .map(Integer::parseInt)
            .toList();
  }
}
