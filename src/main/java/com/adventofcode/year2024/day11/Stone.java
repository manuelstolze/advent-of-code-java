package com.adventofcode.year2024.day11;

import java.util.ArrayList;
import java.util.List;

public class Stone {
  private Long number;

  public Stone(Long number) {
    this.number = number;
  }

  List<Stone> transform(){
    List<Stone> changes = new ArrayList<>();

    if (number == 0){
      changes.add(new Stone(1L));
    }
    else if (hasEvenNumberOfDigits(number)){
      String numStr = Long.toString(number);
      int mid = numStr.length() / 2;
      int left = Integer.parseInt(numStr.substring(0, mid));
      int right = Integer.parseInt(numStr.substring(mid));

      changes.add(new Stone((long) left));
      changes.add(new Stone((long) right));
    }
    else {
      changes.add(new Stone(number * 2024));
    }
    return changes;
  }

  public Long getNumber() {
    return number;
  }

  private boolean hasEvenNumberOfDigits(Long number) {
    return Long.toString(number).length() % 2 == 0;
  }
}
