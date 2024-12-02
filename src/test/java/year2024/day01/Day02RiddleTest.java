package year2024.day01;

import com.adventofcode.year2024.day01.Day01Riddle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day02RiddleTest {

  Day01Riddle day01Riddle = new Day01Riddle();

  @Test
    void testReadFileCorrectly() {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    Day01Riddle.readFile("src/test/resources/2024/01_01.txt", list1, list2);

    assert list1.size() == 6;
    assert list2.size() == 6;
  }

  @Test
  void testSortList() {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    Day01Riddle.readFile("src/test/resources/2024/01_01.txt", list1, list2);

    Collections.sort(list1);
    Collections.sort(list2);

    assert list1.get(0) == 1;
    assert list1.get(1) == 2;
    assert list1.get(2) == 3;
    assert list1.get(3) == 3;
    assert list1.get(4) == 3;
    assert list1.get(5) == 4;

    assert list2.get(0) == 3;
    assert list2.get(1) == 3;
    assert list2.get(2) == 3;
    assert list2.get(3) == 4;
    assert list2.get(4) == 5;
    assert list2.get(5) == 9;
  }

  @Test
  void testCalculateTotalDistance(){
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    Day01Riddle.readFile("src/test/resources/2024/01_01.txt", list1, list2);

    Collections.sort(list1);
    Collections.sort(list2);

    int totalDistance = day01Riddle.calculateTotalDistance(list1, list2);
    assert totalDistance == 11;
  }

  @Test
  void testCalculateTotalDistanceWithSimilarityScore() {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    Day01Riddle.readFile("src/test/resources/2024/01_01.txt", list1, list2);

    Collections.sort(list1);
    Collections.sort(list2);

    int totalDistance = day01Riddle.calculateTotalDistanceWithSimilarityScore(list1, list2);
    assert totalDistance == 31;
  }
}
