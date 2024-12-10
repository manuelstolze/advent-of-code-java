package com.adventofcode.year2024.day10;

import java.util.ArrayList;
import java.util.List;

public class TrailScorer {

  private final TopographicMap map;
  private final List<Trailhead> trailheads;

  // Constructor
  public TrailScorer(TopographicMap map) {
    this.map = map;
    this.trailheads = new ArrayList<>();
  }

  // Calculate scores for all trailheads
  public void calculateTrailheadScoresAndRatings() {
    List<int[]> trailheadPositions = map.findTrailheads();
    for (int[] pos : trailheadPositions) {
      Trailhead trailhead = new Trailhead(pos[0], pos[1]);
      trailhead.calculateScoreAndRating(map);
      trailheads.add(trailhead);
    }
  }

  public int getTotalScore() {
    int totalScore = 0;
    for (Trailhead trailhead : trailheads) {
      totalScore += trailhead.getScore();
    }
    return totalScore;
  }

  public int getTotalRating() {
    int totalRating = 0;
    for (Trailhead trailhead : trailheads) {
      totalRating += trailhead.getRating();
    }
    return totalRating;
  }
}
