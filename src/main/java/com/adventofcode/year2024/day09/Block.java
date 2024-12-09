package com.adventofcode.year2024.day09;

public class Block {
  protected final int id;

    public Block(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isFileBlock() {
       return this instanceof FileBlock;
    }

    public boolean isFreeSpaceBlock() {
        return this instanceof FreeSpaceBlock;
    }
}
