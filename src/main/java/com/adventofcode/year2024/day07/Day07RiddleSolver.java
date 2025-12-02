package com.adventofcode.year2024.day07;

import java.util.ArrayList;
import java.util.List;

public class Day07RiddleSolver {

  private static boolean canBeTrue(long testValue, long[] nums) {
    List<String> operators = List.of("+", "*");
    List<String> combinations = generateCombinations(operators, nums.length - 1);
    return combinations.stream()
        .anyMatch(combination -> evaluateExpression(nums, combination) == testValue);
  }

  private static boolean canBeTrueWithConcatenation(long testValue, long[] nums) {
    List<String> operators = List.of("+", "*", "||");
    List<String> combinations = generateCombinations(operators, nums.length - 1);
    return combinations.stream()
        .anyMatch(combination -> evaluateExpression(nums, combination) == testValue);
  }

  private static long evaluateExpression(long[] nums, String combination) {
    long result = nums[0];
    int numIndex = 1;
    for (int i = 0; i < combination.length(); i++) {
      if (numIndex >= nums.length) {
        break;
      }
      char operator = combination.charAt(i);
      long nextNum = nums[numIndex];
      switch (operator) {
        case '+':
          result += nextNum;
          numIndex++;
          break;
        case '*':
          result *= nextNum;
          numIndex++;
          break;
        case '|':
          if (i + 1 < combination.length() && combination.charAt(i + 1) == '|') {
            result = concatenate(result, nextNum);
            numIndex++;
            i++; // Skip the next '|' character
          }
          break;
      }
    }
    return result;
  }

  private static long concatenate(long a, long b) {
    return Long.parseLong(new StringBuilder().append(a).append(b).toString());
  }

  private static List<String> generateCombinations(List<String> operators, int length) {
    List<String> combinations = new ArrayList<>();
    generateCombinationsHelper(operators, "", length, combinations);
    return combinations;
  }

  private static void generateCombinationsHelper(
      List<String> operators, String current, int length, List<String> combinations) {
    if (length == 0) {
      combinations.add(current);
      return;
    }
    for (String operator : operators) {
      generateCombinationsHelper(operators, current + operator, length - 1, combinations);
    }
  }

  public Long solveRiddleOne(List<String> input) {
    long totalCalibrationResult = 0;
    for (String line : input) {
      try {
        String[] parts = line.split(": ");
        long testValue = Long.parseLong(parts[0].trim());
        String[] numbers = parts[1].trim().split("\s+");
        long[] nums = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          nums[i] = Long.parseLong(numbers[i]);
        }
        if (canBeTrue(testValue, nums)) {
          totalCalibrationResult += testValue;
        }
      } catch (Exception e) {
        // Handle parsing errors or report them
      }
    }
    return totalCalibrationResult;
  }

  public long solveRiddleTwo(List<String> input) {
    long totalCalibrationResult = 0;
    for (String line : input) {
      try {
        String[] parts = line.split(": ");
        long testValue = Long.parseLong(parts[0].trim());
        String[] numbers = parts[1].trim().split("\s+");
        long[] nums = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          nums[i] = Long.parseLong(numbers[i]);
        }
        if (canBeTrueWithConcatenation(testValue, nums)) {
          totalCalibrationResult += testValue;
        }
      } catch (Exception e) {
        // Handle parsing errors or report them
      }
    }
    return totalCalibrationResult;
  }
}
