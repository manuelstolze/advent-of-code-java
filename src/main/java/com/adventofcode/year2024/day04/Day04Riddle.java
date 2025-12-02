package com.adventofcode.year2024.day04;

import com.adventofcode.common.resolver.AbstractRiddleSolver;
import java.util.List;

public class Day04Riddle extends AbstractRiddleSolver<List<String>> {

  private static final String TARGET_WORD_RIDDLE_ONE = "XMAS";
  private static final String TARGET_WORD_RIDDLE_TWO = "A";

  @Override
  public int solveRiddleOne(List<String> lines) {
    WordSearch wordSearch = new WordSearch(TARGET_WORD_RIDDLE_ONE);
    char[][] grid = createGridFromFile(lines);
    return wordSearch.countWordOccurrences(grid);
  }

  @Override
  public int solveRiddleTwo(List<String> lines) {
    WordSearch wordSearch = new WordSearch(TARGET_WORD_RIDDLE_TWO);
    char[][] grid = createGridFromFile(lines);
    return wordSearch.countWordsInXShape(grid);
  }

  private char[][] createGridFromFile(List<String> lines) {
    InputConverter inputConverter = new InputConverter();
    return inputConverter.convertToCharGrid(lines);
  }
}
