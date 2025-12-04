package com.adventofcode.year2025.application.usecases;

import com.adventofcode.year2025.domain.BatteryBank;
import com.adventofcode.year2025.domain.RiddleUseCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SolveDay03RiddleUseCase implements RiddleUseCase<Integer> {
  final List<BatteryBank> batteryBanks = new ArrayList<>();

  public SolveDay03RiddleUseCase(BufferedReader reader) throws IOException {
    String fline;
    while ((fline = reader.readLine()) != null) {

      String finalFline = fline;
      var s =
          IntStream.range(0, fline.length()) // Stream von Indizes
              .mapToObj(
                  i -> new BatteryBank.Battery(i, finalFline.charAt(i) - '0')) // index + charge
              .toList();

      batteryBanks.add(BatteryBank.initializeBatteryBank(s));
    }
  }

  @Override
  public Integer solveRiddleOne() {
    // Implementation for riddle one
    return null;
  }

  @Override
  public Integer solveRiddleTwo() {
    // Implementation for riddle two
    return null;
  }
}
