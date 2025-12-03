package com.adventofcode.year2025.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRanges {

  private final List<ProductRange> productRanges;

  private ProductRanges(List<ProductRange> ranges) {
    this.productRanges = ranges;
  }

  public static ProductRanges fromFile(BufferedReader bufferedReader) throws IOException {
    List<ProductRange> ranges = new ArrayList<>();

    String fline;
    while ((fline = bufferedReader.readLine()) != null) {

      List<ProductRange> newRanges =
          Arrays.stream(fline.split(","))
              .map(line -> line.split("-"))
              .map(parts -> new ProductRange(Long.parseLong(parts[0]), Long.parseLong(parts[1])))
              .toList();

      ranges.addAll(newRanges);
    }
    return new ProductRanges(ranges);
  }

  public List<ProductRange> get() {
    return productRanges;
  }
}
