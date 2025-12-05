package com.adventofcode.year2025.application.usecases;

import static com.adventofcode.common.MathUtils.mod;

import com.adventofcode.year2025.domain.RiddleUseCase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SolveDay01RiddleUseCase implements RiddleUseCase<Integer, Integer> {

  private static final int STARTING_DIAL_POS = 50;

  private final List<Movement> movements = new java.util.ArrayList<>();

  public SolveDay01RiddleUseCase(FileReader fileReader) {
    this.readFile(fileReader);
  }

  @Override
  public Integer solveRiddleOne() {
    int dial = STARTING_DIAL_POS;
    int zeroCount = 0;
    for (final Movement movement : movements) {
      final int delta = movement.direction * movement.amplitude;
      dial = mod(dial + delta, 100);
      if (dial == 0) zeroCount++;
    }
    return zeroCount;
  }

  @Override
  public Integer solveRiddleTwo() {
    int dial = STARTING_DIAL_POS;
    int zeroCount = 0;
    for (final Movement movement : movements) {
      final int delta = movement.direction * movement.amplitude;
      final boolean wasZero = dial == 0;
      dial += delta;

      if (dial > 0) {
        zeroCount += dial / 100;
      } else {
        zeroCount += (wasZero ? 0 : 1) - dial / 100;
      }
      dial = mod(dial, 100);
    }

    return zeroCount;
  }

  private void readFile(FileReader fileReader) {
    try (BufferedReader reader = new BufferedReader(fileReader)) {
      String line;

      while ((line = reader.readLine()) != null) {
        if (line.startsWith("L")) {
          movements.add(new Movement(-1, Integer.parseInt(line.substring(1))));
        }
        if (line.startsWith("R")) {
          movements.add(new Movement(+1, Integer.parseInt(line.substring(1))));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  record Movement(int direction, int amplitude) {}
}
