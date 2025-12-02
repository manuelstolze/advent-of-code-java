package com.adventofcode.year2024.day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disk {

  private final List<Block> blocks = new ArrayList<>();

  public void generateInitialBlocks(List<Integer> lengths) {
    int fileId = 0;
    for (int i = 0; i < lengths.size(); i++) {
      int length = lengths.get(i);

      boolean isFileBlock = i % 2 == 0;

      for (int j = 0; j < length; j++) {
        if (isFileBlock) {
          blocks.add(new FileBlock(fileId));
        } else {
          blocks.add(new FreeSpaceBlock());
        }
      }

      if (isFileBlock) {
        fileId++;
      }
    }
  }

  public void compact() {
    int leftmostFreeSpace = 0;
    while (true) {
      System.out.println(blocks);
      int rightmostBlock = findRightmostBlock();
      if (rightmostBlock == -1) {
        break;
      }
      leftmostFreeSpace = findLeftmostFreeSpace(leftmostFreeSpace);

      if (leftmostFreeSpace == blocks.size() || leftmostFreeSpace >= rightmostBlock) {
        break;
      }

      Collections.swap(blocks, rightmostBlock, leftmostFreeSpace);
    }
  }

  public void compactByFiles() {
    List<Integer> fileIds = getFileIdsInDescendingOrder();

    for (int fileId : fileIds) {
      int[] fileRange = findFileRange(fileId);
      int fileSize = fileRange[1] - fileRange[0] + 1;

      int freeStart = findFreeSpace(fileSize, fileRange[0]);
      if (freeStart != -1) {
        moveFile(fileId, fileRange, freeStart);
        // printDiskState();
      }
    }
  }

  public Long checkSum() {
    long sum = 0;
    for (Block block : blocks) {
      if (block.isFileBlock()) {
        sum += (long) block.getId() * blocks.indexOf(block);
      }
    }
    return sum;
  }

  public List<Block> getBlocks() {
    return blocks;
  }

  private int findRightmostBlock() {
    for (int i = blocks.size() - 1; i >= 0; i--) {
      if (blocks.get(i).isFileBlock()) {
        return i;
      }
    }
    return -1; // No blocks found
  }

  private int findLeftmostFreeSpace(int startIndex) {
    for (int i = startIndex; i < blocks.size(); i++) {
      if (blocks.get(i).isFreeSpaceBlock()) {
        return i;
      }
    }
    return blocks.size(); // No free space found
  }

  private List<Integer> getFileIdsInDescendingOrder() {
    List<Integer> fileIds = new ArrayList<>();
    for (Block block : blocks) {
      if (block.isFileBlock() && !fileIds.contains(block.getId())) {
        fileIds.add(block.getId());
      }
    }
    fileIds.sort(Collections.reverseOrder());
    return fileIds;
  }

  private int[] findFileRange(int fileId) {
    int start = -1, end = -1;
    for (int i = 0; i < blocks.size(); i++) {
      if (blocks.get(i).isFileBlock() && blocks.get(i).getId() == fileId) {
        if (start == -1) {
          start = i;
        }
        end = i;
      }
    }
    return new int[] {start, end};
  }

  private int findFreeSpace(int size, int start) {
    int freeCount = 0, freeStart = -1;

    for (int i = 0; i < blocks.size(); i++) {
      if (blocks.get(i).isFreeSpaceBlock()) {

        if (freeCount == 0) {
          freeStart = i;
        }
        freeCount++;
        if (freeCount == size && freeStart <= start) {
          return freeStart;
        }
      } else {
        freeCount = 0;
      }
    }
    return -1;
  }

  private void moveFile(int fileId, int[] fileRange, int freeStart) {
    int fileSize = fileRange[1] - fileRange[0] + 1;

    // Clear the old file range
    for (int i = fileRange[0]; i <= fileRange[1]; i++) {
      blocks.set(i, new FreeSpaceBlock());
    }

    // Place file in the new range
    for (int i = 0; i < fileSize; i++) {
      blocks.set(freeStart + i, new FileBlock(fileId));
    }
  }

  public void printDiskState() {
    StringBuilder state = new StringBuilder();
    for (Block block : blocks) {
      state.append(block.toString());
    }
    System.out.println(state);
  }
}
