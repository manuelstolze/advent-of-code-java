package com.adventofcode.year2024.day09;

import java.util.List;

public class Day09RiddleSolver {

  public Long solveRiddleOne(List<String> input) {
    Disk disk = new Disk();
    disk.generateInitialBlocks(DiskParser.parseDiskMap(input.get(0)));
    disk.compact();

    return disk.checkSum();
  }

  public Long solveRiddleTwo(List<String> input) {
    Disk disk = new Disk();
    disk.generateInitialBlocks(DiskParser.parseDiskMap(input.get(0)));
    disk.compactByFiles();

    return disk.checkSum();
  }
}
