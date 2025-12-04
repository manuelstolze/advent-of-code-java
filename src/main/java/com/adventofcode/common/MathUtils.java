package com.adventofcode.common;

public class MathUtils {

  public static int mod(final int a, final int b) {
    int modulo = a % b;
    if (modulo < 0) {
      modulo += b;
    }
    return modulo;
  }

  public static long pow(final int base, final int exponent) {
    if (exponent == 0) {
      if (base == 0) throw new IllegalArgumentException("0^0 cannot be computed");
      return 1;
    }
    if (base == 1) return 1;
    if (base == 2) return 1L << exponent;

    long result = base;
    for (int i = 1; i < exponent; i++) {
      result *= base;
    }
    return result;
  }
}
