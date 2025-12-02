package com.adventofcode.year2024.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionExtractor {

  private static final String MUL_REGEX = "mul\\(\\d+,\\d+\\)";
  private static final String CONTROL_REGEX = "do\\(\\)|don't\\(\\)";
  private static final String NUMBER_REGEX = "\\d+";

  private static final Pattern MUL_PATTERN = Pattern.compile(MUL_REGEX);
  private static final Pattern INSTRUCTION_PATTERN =
      Pattern.compile(MUL_REGEX + "|" + CONTROL_REGEX);
  private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

  public static List<List<Integer>> extract(String corruptedInstructions) {
    Matcher matcher = MUL_PATTERN.matcher(corruptedInstructions);
    return matcher.results().map(result -> extractNumbers(result.group())).toList();
  }

  public static List<List<Integer>> extractOnlyEnabledInstructions(String corruptedInstructions) {
    List<List<Integer>> instructions = new ArrayList<>();
    Matcher matcher = INSTRUCTION_PATTERN.matcher(corruptedInstructions);

    InstructionStatus status = InstructionStatus.getInstance();

    while (matcher.find()) {
      String instruction = matcher.group();
      if (instruction.equals("do()")) {
        status.setEnabled(true);
        continue;
      } else if (instruction.equals("don't()")) {
        status.setEnabled(false);
        continue;
      }

      if (status.isEnabled()) {
        instructions.add(extractNumbers(instruction));
      }
    }
    return instructions;
  }

  private static List<Integer> extractNumbers(String instruction) {
    List<Integer> numbers = new ArrayList<>();
    Matcher matcher = NUMBER_PATTERN.matcher(instruction);
    while (matcher.find()) {
      numbers.add(Integer.parseInt(matcher.group()));
    }
    return numbers;
  }
}
