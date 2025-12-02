package com.adventofcode.year2024.day09;

public class FreeSpaceBlock extends Block {
  public FreeSpaceBlock() {
    super(-1);
  }

  @Override
  public String toString() {
    return ".";
  }
}
