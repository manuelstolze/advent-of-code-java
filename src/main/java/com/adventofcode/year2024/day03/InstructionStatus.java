package com.adventofcode.year2024.day03;

public class InstructionStatus {
  private static InstructionStatus instance;
  private boolean isEnabled;

  private InstructionStatus() {
    isEnabled = true;
  }

  public static InstructionStatus getInstance() {
    if (instance == null) {
      instance = new InstructionStatus();
    }
    return instance;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }
}
