package com.adventofcode.year2025.domain;

import java.util.ArrayList;
import java.util.List;

public class BatteryBank {

  private List<Battery> batteries = new ArrayList<>();

  private BatteryBank(List<Battery> batteries) {
    this.batteries = batteries;
  }

  public static BatteryBank initializeBatteryBank(List<Battery> batteries) {
    return new BatteryBank(batteries);
  }

  public record Battery(int position, int charge) {
    boolean compareCharge(Battery other) {
      return this.charge == other.charge;
    }
  }
}
