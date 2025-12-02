package com.adventofcode;

import com.adventofcode.year2025.application.usecases.SolveDay01RiddleUseCase;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AdventOfCodeApplication {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("Hello world!");

    new SolveDay01RiddleUseCase(new FileReader("src/main/resources/2025/01.txt")).solveRiddles();
  }
}
