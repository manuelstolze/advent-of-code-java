package com.adventofcode.year2024.day09;

public class FileBlock extends Block{
  public FileBlock(int id) {
    super(id);
  }

  @Override
  public String toString() {
    return String.valueOf(id);
  }


}
