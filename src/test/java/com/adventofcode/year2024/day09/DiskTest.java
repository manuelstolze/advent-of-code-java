package com.adventofcode.year2024.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class DiskTest {

  @Test
  void testParseInput() {
    Disk disk = new Disk();
    List<Integer> lengths = List.of(2, 3, 3, 3, 1);
    disk.generateInitialBlocks(lengths);
    assertEquals(12, disk.getBlocks().size());

    assertEquals('0', disk.getBlocks().get(0).getId());
    assertEquals('.', disk.getBlocks().get(3).getId());
  }

  @Test
  void testCompact() {
    Disk disk = new Disk();
    List<Integer> lengths = List.of(1, 2, 3, 4, 5);
    disk.generateInitialBlocks(lengths);
    disk.compact();
    assertEquals(15, disk.getBlocks().size());

    assertEquals('0', disk.getBlocks().get(0).getId());
    assertEquals('2', disk.getBlocks().get(1).getId());
    assertEquals('2', disk.getBlocks().get(2).getId());
    assertEquals('1', disk.getBlocks().get(3).getId());
    assertEquals('1', disk.getBlocks().get(4).getId());
    assertEquals('1', disk.getBlocks().get(5).getId());
    assertEquals('2', disk.getBlocks().get(6).getId());
    assertEquals('2', disk.getBlocks().get(7).getId());
    assertEquals('2', disk.getBlocks().get(8).getId());
  }
}
