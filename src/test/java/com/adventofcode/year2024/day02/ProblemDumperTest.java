package com.adventofcode.year2024.day02;

import com.adventofcode.year2024.day02.ProblemDumper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProblemDumperTest {

  @Test
  void saveWithoutRemovingAnyLevels(){
    List<Integer> list1 = List.of(7,6,4,2,1);
    List<Integer> list2 = List.of(1,3,6,7,9);

    assert ProblemDumper.isSave(list1);
    assert ProblemDumper.isSave(list2);
  }

  @Test
  void unsafeRegardlessWhichLevelIsRemoved(){
    List<Integer> list1 = List.of(1,2,7,8,9);
    List<Integer> list2 = List.of(9,7,6,2,1);

    assert !ProblemDumper.isSave(list1);
    assert !ProblemDumper.isSave(list2);
  }

  @Test
  void saveByRemovingOneLevel(){
    List<Integer> list1 = List.of(1,3,2,4,5);
    List<Integer> list2 = List.of(8,6,4,4,1);

    assert ProblemDumper.isSave(list1);
    assert ProblemDumper.isSave(list2);
  }

}
