package com.adventofcode;

import com.adventofcode.year2025.application.usecases.SolveDay01RiddleUseCase;
import com.adventofcode.year2025.application.usecases.SolveDay02RiddleUseCase;
import com.adventofcode.year2025.application.usecases.SolveDay03RiddleUseCase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdventOfCodeApplication {
  public static void main(String[] args) throws IOException {
    System.out.println("Welcome user!");

    int day = 1;

    System.out.println("\nDay " + day++ + ":");
    new SolveDay01RiddleUseCase(new FileReader("src/main/resources/2025/01.txt")).solveRiddles();

    System.out.println("\nDay " + day++ + ":");
    new SolveDay02RiddleUseCase(
            new BufferedReader(new FileReader("src/main/resources/2025/02.txt")))
        .solveRiddles();

    System.out.println("\nDay " + day++ + ":");
    new SolveDay03RiddleUseCase(
            new BufferedReader(new FileReader("src/main/resources/2025/03.txt")))
        .solveRiddles();
  }
}
