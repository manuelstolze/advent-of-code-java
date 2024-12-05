package com.adventofcode.year2024.day05;

import com.adventofcode.common.AdventOfCodeFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day05FileReader extends AdventOfCodeFileReader {
  private static final String RULES_DELIMITER = "\\|";
  private static final String UPDATES_DELIMITER = ",";

  private final PageOrderingRules pageOrderingRules = new PageOrderingRules();
  private final PageUpdates pageUpdates = new PageUpdates();

  public Day05FileReader() {}

  @Override
  public List<String> readFile(String file) {
    List<String> lines = super.readFile(file);
    lines.forEach(this::parseLine);
    return lines;
  }

  public PageOrderingRules getPageOrderingRules() {
    return pageOrderingRules;
  }

  public PageUpdates getPageUpdates() {
    return pageUpdates;
  }

  private void parseLine(String line) {
    if (line.contains("|")) {
      parseRule(line);
    } else if (line.contains(",")) {
      parseUpdate(line);
    }
  }

  private void parseRule(String line) {
    String[] ruleParts = line.split(RULES_DELIMITER);
    try {
      int sourcePage = Integer.parseInt(ruleParts[0].trim());
      int targetPage = Integer.parseInt(ruleParts[1].trim());
      pageOrderingRules.addRule(sourcePage, targetPage);
    } catch (NumberFormatException e) {
      System.out.println("Error parsing rule: " + line);
    }
  }

  private void parseUpdate(String line) {
    try {
      List<Integer> update = Arrays.stream(line.split(UPDATES_DELIMITER))
              .map(String::trim)
              .map(Integer::parseInt)
              .collect(Collectors.toList());
      pageUpdates.addUpdate(update);
    } catch (NumberFormatException e) {
      System.out.println("Error parsing rule: " + line);
    }
  }
}
