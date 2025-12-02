package com.adventofcode.common;

public class MathUtils {

  public static int mod(final int a, final int b) {
    int modulo = a % b;
    if (modulo < 0) {
      modulo += b;
    }
    return modulo;
  }
}
