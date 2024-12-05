package com.adventofcode.common.resolver;

public abstract class AbstractRiddleSolver<T> {

  abstract protected int solveRiddleOne(T input);

  abstract protected int solveRiddleTwo(T input);
}