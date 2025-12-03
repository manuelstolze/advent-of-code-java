package com.adventofcode.year2025.domain;

public record ProductRange(long start, long end) {
  public boolean contains(final long value) {
    return start <= value && value <= end;
  }
}
