package com.adventofcode.year2025.application.usecases;

import com.adventofcode.common.MathUtils;
import com.adventofcode.year2025.domain.ProductRange;
import com.adventofcode.year2025.domain.ProductRanges;
import com.adventofcode.year2025.domain.RiddleUseCase;
import java.io.BufferedReader;
import java.io.IOException;

public class SolveDay02RiddleUseCase implements RiddleUseCase<Long> {

  private final ProductRanges productRanges;

  public SolveDay02RiddleUseCase(BufferedReader reader) throws IOException {
    productRanges = ProductRanges.fromFile(reader);
  }

  @Override
  public Long solveRiddleOne() {
    long total = 0L;
    final var ranges = productRanges.get();

    for (final ProductRange range : ranges) {
      final int startLength = String.valueOf(range.start()).length();
      final int endLength = String.valueOf(range.end()).length();

      // Skip if both lengths are odd
      if (startLength == endLength && startLength % 2 == 1) continue;

      final int length;
      if (startLength == endLength) {
        length = startLength;
      } else {
        if (startLength % 2 == 1) {
          length = endLength;
        } else {
          length = startLength;
        }
      }

      // Calculate the search space for palindromic numbers of the given length
      final long searchStart = MathUtils.pow(10, length / 2 - 1);
      final long searchEnd = MathUtils.pow(10, length / 2) - 1;

      // Generate all numbers with the given length that are palindromic by construction
      for (long n = searchStart; n <= searchEnd; n++) {
        final long value = Long.parseLong(String.valueOf(n).repeat(2));
        if (range.contains(value)) {
          total += value;
        }
      }
    }
    return total;
  }

  @Override
  public Long solveRiddleTwo() {
    return 0L;
  }
}
