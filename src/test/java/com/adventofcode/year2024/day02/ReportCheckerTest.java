package com.adventofcode.year2024.day02;

import com.adventofcode.year2024.day02.ReportChecker;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReportCheckerTest {

  @Test
  void testSuccessFullIncrease() {
    List<Integer> list = List.of(1, 3, 6, 7, 9);
    assert ReportChecker.isIncreasing(list);
  }

  @Test
  void testFailIncreaseBecauseIncreaseOfFive() {
    List<Integer> list = List.of(1, 2, 7, 8, 9);
    assert !ReportChecker.isIncreasing(list);
  }

  @Test
  void testSuccessFullDecrease() {
    List<Integer> list = List.of(7,6,4,2,1);
    assert ReportChecker.isDecreasing(list);
  }

  @Test
  void testFailDecreaseBecauseDecreaseOfFour() {
    List<Integer> list = List.of(9,7,6,2,1);
    assert !ReportChecker.isIncreasing(list);
  }

  @Test
  void testFailIncreaseAndDecrease() {
    List<Integer> list = List.of(1,3,2,4,5);
    assert !ReportChecker.isIncreasingOrDecreasing(list);


  }

  @Test
  void testFailNoIncreaseOrDecrease() {
    List<Integer> list = List.of(8,6,4,4,1);
    assert !ReportChecker.isIncreasingOrDecreasing(list);
  }
}
