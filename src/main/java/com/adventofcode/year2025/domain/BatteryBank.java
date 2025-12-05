package com.adventofcode.year2025.domain;

import java.util.List;

public class BatteryBank {

  final int MAX_DIGIT_COUNT = 2;
  final int MAX_DIGIT_COUNT_LIMIT_OVERRIDE = 12;

  private final List<Battery> batteries;
  private final int providedJoltage;

  long providedJoltageWithLimitOverride = 0;

  private BatteryBank(List<Battery> batteries) {
    this.batteries = batteries;
    this.providedJoltage = Integer.parseInt(computeJoltageAsString(MAX_DIGIT_COUNT, batteries));
    this.providedJoltageWithLimitOverride =
        Long.parseLong(computeJoltageAsString(MAX_DIGIT_COUNT_LIMIT_OVERRIDE, batteries));
  }

  public static BatteryBank initializeBatteryBank(List<Battery> batteries) {
    return new BatteryBank(batteries);
  }

  private int getMaxJoltageBattery(final int start, final int end) {
    int max = 0;
    int maxIndex = -1;

    for (int i = start; i < end; i++) {
      Battery battery = batteries.get(i);
      if (battery.hasHigherCharge(max)) {
        max = battery.charge;
        maxIndex = i;
      }
    }

    if (maxIndex < 0)
      throw new IllegalArgumentException(
          "Could not find non zero value in " + batteries.toString());
    return maxIndex;
  }

  private String computeJoltageAsString(int digitCount, List<Battery> batteries) {
    StringBuilder sb = new StringBuilder(digitCount);
    int previousDigitIndex = -1;

    for (int i = digitCount - 1; i >= 0; i--) {
      int maxIndex = getMaxJoltageBattery(previousDigitIndex + 1, batteries.size() - i);
      previousDigitIndex = maxIndex;

      sb.append(batteries.get(maxIndex).charge());
    }

    return sb.toString();
  }

  public int getProvidedJoltage() {
    return providedJoltage;
  }

  public Long getProvidedJoltageWithLimitOverride() {
    return providedJoltageWithLimitOverride;
  }

  public record Battery(int charge) {
    boolean hasHigherCharge(int charge) {
      return this.charge > charge;
    }
  }
}
