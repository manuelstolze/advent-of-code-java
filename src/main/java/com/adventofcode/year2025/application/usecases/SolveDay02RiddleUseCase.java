package com.adventofcode.year2025.application.usecases;

import com.adventofcode.common.MathUtils;
import com.adventofcode.year2025.domain.ProductRange;
import com.adventofcode.year2025.domain.ProductRanges;
import com.adventofcode.year2025.domain.RiddleUseCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.LongStream;

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
    final long total = 0L;
    final int maxDigits = 10;
    final var ranges = productRanges.get();
    final Set<Long> repeatingNumbers = new HashSet<>();

    // Generate all numbers with repeating digit blocks for each possible digit length
    for (int digit = 2; digit <= maxDigits; digit++) {
      for (int blocklength = 1; blocklength <= digit / 2; blocklength++) {
        if (digit % blocklength != 0) continue;

        final int repeat = digit / blocklength;
        final long start = MathUtils.pow(10, blocklength - 1);
        final long end = MathUtils.pow(10, blocklength) - 1;

        // Create numbers by repeating the block and add them to the set
        LongStream.range(start, end + 1)
            .mapToObj(value -> String.valueOf(value).repeat(repeat))
            .map(Long::parseLong)
            .forEach(repeatingNumbers::add);
      }
    }

    // Check each generated number against all ranges and sum up the valid ones
    for (Long number : repeatingNumbers) {
      for (final ProductRange range : ranges) {
        if (range.contains(number)) {
          return number;
        }
      }
    }

    return total;
  }
}
