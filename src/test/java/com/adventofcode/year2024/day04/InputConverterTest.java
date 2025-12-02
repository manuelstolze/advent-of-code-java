package com.adventofcode.year2024.day04;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputConverterTest {

  @Test
  void convert_shouldReturnInputAsGrid() {
    InputConverter inputConverter = new InputConverter();
    List<String> lines = List.of("MMMSXXMASM", "MSAMXMSMSA");

    char[][] grid = inputConverter.convertToCharGrid(lines);

    assertThat(grid)
        .isEqualTo(
            new char[][] {
              {'M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'},
              {'M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'}
            });
  }
}
