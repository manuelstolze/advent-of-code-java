package com.adventofcode.year2024.day13;

public class ClawMachine {
  static final int MAX_PRESSES = 100;

  private Button buttonA;
  private Button buttonB;
  private Prize prize;

  public ClawMachine(Button buttonA, Button buttonB, Prize prize) {
      this.buttonA = buttonA;
      this.buttonB = buttonB;
      this.prize = prize;
  }

  public int calculateMinimumTokens(){
    int xTarget = prize.getXPosition();
    int yTarget = prize.getYPosition();

    // Use linear diophantine equation
    int [][] coefficients = {
            {buttonA.getXDelta(), buttonB.getXDelta(), xTarget},
            {buttonA.getYDelta(), buttonB.getYDelta(), yTarget}
    };

    int[] solution = solveDiophantine(coefficients);

    if (solution == null) {
      return -1;
    }

    int aPresses = solution[0];
    int bPresses = solution[1];

    return aPresses * buttonA.getCost() + bPresses * buttonB.getCost();
  }

    private int[] solveDiophantine(int[][] coefficients) {
      int aX = coefficients[0][0], bX = coefficients[0][1], cX = coefficients[0][2];
      int aY = coefficients[1][0], bY = coefficients[1][1], cY = coefficients[1][2];


      for (int a = 0; a <= MAX_PRESSES; a++){
        for (int b = 0; b <= MAX_PRESSES; b++){
          if (aX * a + bX * b == cX && aY * a + bY * b == cY){
            return new int[]{a, b};
          }
        }
      }
      return null;
    }
}
