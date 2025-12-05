package com.adventofcode.year2025.domain;

import java.util.List;

public class BatteryBank {

  private final List<Battery> batteries;
  private final int providedJoltage;

  private BatteryBank(List<Battery> batteries) {
    this.batteries = batteries;

    final int firstBatteryIndex = getMaxJoltageBattery(0, batteries.size() - 1);
    final int secondBatteryIndex = getMaxJoltageBattery(firstBatteryIndex + 1, batteries.size());
    final String max =
        batteries.get(firstBatteryIndex).charge
            + String.valueOf(batteries.get(secondBatteryIndex).charge);

    this.providedJoltage = Integer.parseInt(max);
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

  public int getProvidedJoltage() {
    return providedJoltage;
  }

  public record Battery(int charge) {
    boolean hasHigherCharge(int charge) {
      return this.charge > charge;
    }
  }
}
