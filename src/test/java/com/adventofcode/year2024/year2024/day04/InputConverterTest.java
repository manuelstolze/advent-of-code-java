package com.adventofcode.year2024.year2024.day04;

import com.adventofcode.year2024.day04.InputConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InputConverterTest {

  @Test
  void convert_shouldReturnInputAsGrid() {
    InputConverter inputConverter = new InputConverter();
    List<String> lines = List.of("MMMSXXMASM","MSAMXMSMSA");

    char[][] grid = inputConverter.convertToCharGrid(lines);

    assertThat(grid).isEqualTo(new char[][]{{'M', 'M', 'M','S','X','X', 'M','A','S','M'}, {'M', 'S', 'A','M','X','M', 'S','M','S','A'}});
  }
}
