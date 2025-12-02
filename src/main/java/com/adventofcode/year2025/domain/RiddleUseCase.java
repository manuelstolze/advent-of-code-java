package com.adventofcode.year2025.domain;

public interface RiddleUseCase<T> {

  T solveRiddleOne();

  T solveRiddleTwo();

  default void solveRiddles() {
    System.out.println("Solution of Riddle One: " + solveRiddleOne());
    System.out.println("Solution of Riddle Two: " + solveRiddleTwo());
  }
}
