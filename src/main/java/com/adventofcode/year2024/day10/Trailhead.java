package com.adventofcode.year2024.day10;

public class Trailhead {
  private final int x;
  private final int y;
  private int score;
  private int rating;

  public Trailhead(int x, int y) {
    this.x = x;
    this.y = y;
    this.score = 0;
    this.rating = 0;
  }

  public void calculateScoreAndRating(TopographicMap map) {
    HikingTrail trail = new HikingTrail();
    this.calculateScore(trail, map);
    this.calculateRating(trail, map);
  }

  public void calculateScore(HikingTrail trail, TopographicMap map) {
    this.score = trail.exploreTrailsFrom(x, y, map);
  }

  public void calculateRating(HikingTrail trail, TopographicMap map) {
    this.rating = trail.exploreDistinctTrailsFrom(x, y, map);
  }

  public int getScore() {
    return score;
  }

  public int getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return "Trailhead at (" + x + ", " + y + ") with score: " + score;
  }
}
