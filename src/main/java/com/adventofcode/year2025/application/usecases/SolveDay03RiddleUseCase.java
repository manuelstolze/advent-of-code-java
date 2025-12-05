package com.adventofcode.year2025.application.usecases;

import com.adventofcode.year2025.domain.BatteryBank;
import com.adventofcode.year2025.domain.RiddleUseCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SolveDay03RiddleUseCase implements RiddleUseCase<Integer> {
  final List<BatteryBank> batteryBanks = new ArrayList<>();

  public SolveDay03RiddleUseCase(BufferedReader reader) throws IOException {
    reader
        .lines()
        .map(this::parseLineToBatteryList)
        .map(BatteryBank::initializeBatteryBank)
        .forEach(batteryBanks::add);
  }

  @Override
  public Integer solveRiddleOne() {
    return batteryBanks.stream().map(BatteryBank::getProvidedJoltage).reduce(0, Integer::sum);
  }

  @Override
  public Integer solveRiddleTwo() {
    // Implementation for riddle two
    return null;
  }

  private List<BatteryBank.Battery> parseLineToBatteryList(String line) {
    return line.chars().mapToObj(c -> new BatteryBank.Battery(c - '0')).toList();
  }
}
