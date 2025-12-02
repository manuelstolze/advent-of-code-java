package com.adventofcode.year2024.day10;

import com.adventofcode.common.resolver.AbstractRiddleSolver;
import java.util.List;

public class Day10RiddleSolver extends AbstractRiddleSolver<List<String>> {
  @Override
  public int solveRiddleOne(List<String> input) {
    int[][] grid = this.convertInputToIntGrid(input);

    TrailScorer scorer = new TrailScorer(new TopographicMap(grid));
    scorer.calculateTrailheadScoresAndRatings();

    return scorer.getTotalScore();
  }

  @Override
  public int solveRiddleTwo(List<String> input) {
    int[][] grid = this.convertInputToIntGrid(input);

    TrailScorer scorer = new TrailScorer(new TopographicMap(grid));
    scorer.calculateTrailheadScoresAndRatings();

    return scorer.getTotalRating();
  }

  public int[][] convertInputToIntGrid(List<String> input) {
    int[][] grid = new int[input.size()][input.get(0).length()];
    for (int row = 0; row < input.size(); row++) {
      for (int col = 0; col < input.get(row).length(); col++) {
        grid[row][col] = input.get(row).charAt(col) - '0';
      }
    }
    return grid;
  }
}
