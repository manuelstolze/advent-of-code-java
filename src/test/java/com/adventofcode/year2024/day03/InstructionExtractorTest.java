package com.adventofcode.year2024.day03;

import com.adventofcode.common.AdventOfCodeFileReader;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InstructionExtractorTest {

  List<String> fileContent = null;

  @BeforeEach
  void setUp() {
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
    fileContent = fileReader.readFile("src/test/resources/2024/03.txt");
  }

  @Test
  void testExtractInstruction() {
    String instruction = fileContent.getFirst();
    List<List<Integer>> instructions = InstructionExtractor.extract(instruction);

    assert instructions.size() == 4;
    assert instructions.get(0).get(0).equals(2);
    assert instructions.get(0).get(1).equals(4);
  }

  @Test
  void testExtractOnlyEnabledInstructionsInstructions() {
    AdventOfCodeFileReader fileReader = new AdventOfCodeFileReader();
    fileContent = fileReader.readFile("src/test/resources/2024/03_02.txt");

    String instruction = fileContent.getFirst();
    List<List<Integer>> instructions =
        InstructionExtractor.extractOnlyEnabledInstructions(instruction);

    assert instructions.size() == 2;
    assert instructions.get(0).get(0).equals(2);
    assert instructions.get(0).get(1).equals(4);

    assert instructions.get(1).get(0).equals(8);
    assert instructions.get(1).get(1).equals(5);
  }
}
