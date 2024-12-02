package com.adventofcode.year2024.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01Riddle {
  public Day01Riddle() {}

  public void solveRiddleOne(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    readFile("src/main/resources/2024/01.txt", list1, list2);

    Collections.sort(list1);
    Collections.sort(list2);

    System.out.println("Answer One: " +calculateTotalDistance(list1, list2));
  }

  public void solveRiddleTwo(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    readFile("src/main/resources/2024/01.txt", list1, list2);

    Collections.sort(list1);
    Collections.sort(list2);

    System.out.println("Answer Two: " + calculateTotalDistanceWithSimilarityScore(list1, list2));
  }


  public static void readFile(String filePath, List<Integer> list1, List<Integer> list2) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\\s+");
        if (parts.length == 2) {
          list1.add(Integer.parseInt(parts[0]));
          list2.add(Integer.parseInt(parts[1]));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int calculateTotalDistance(List<Integer> list1, List<Integer> list2) {
    int length = list1.size();
    int totalDistance = 0;

    for (int i = 0; i < length; i++) {
      totalDistance += Math.abs(list1.get(i) - list2.get(i));
    }

    return totalDistance;
  }

  public int calculateTotalDistanceWithSimilarityScore(List<Integer> list1, List<Integer> list2) {
    int totalScore = 0;

    for (int list1value : list1) {
      long similarityScore = list1value * list2.stream().filter(j -> j == list1value).count(); // to avoid multiply with zero

      totalScore += (int) similarityScore;
    }

    return totalScore;
  }
}
