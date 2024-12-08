package com.adventofcode.year2024.day08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AntinodeCalculator {
  private final List<String> map;
  private final int rows;
  private final int cols;

  public AntinodeCalculator(List<String> map) {
    this.map = map;
    this.rows = map.size();
    this.cols = map.get(0).length();
  }

  public Set<String> calculateAntinodes(){
    Set<String> antinodes = new HashSet<>();
    List<Antenna> antennas = findAntennas();

    for(int i = 0; i < antennas.size(); i++){
      for (int j = i + 1; j < antennas.size(); j++){
        Antenna antenna1 = antennas.get(i);
        Antenna antenna2 = antennas.get(j);

        if (antenna1.frequency() == antenna2.frequency()){
          addAntinodes(antinodes, antenna1, antenna2);
        }
      }
    }
    return antinodes;
  }

  public Set<String> calculateAntinodesWithHarmonicResonance(){
    Set<String> antinodes = new HashSet<>();
    List<Antenna> antennas = findAntennas();

    for(int i = 0; i < antennas.size(); i++){
      for (int j = i + 1; j < antennas.size(); j++){
        Antenna antenna1 = antennas.get(i);
        Antenna antenna2 = antennas.get(j);

        if (antenna1.frequency() == antenna2.frequency()){
          addAntinodesWithHarmonicResonance(antinodes, antenna1, antenna2);
        }
      }
    }
    return antinodes;
  }

  private List<Antenna> findAntennas(){
    List<Antenna> antennas = new ArrayList<>();
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        char frequency = map.get(i).charAt(j);
        if (frequency != '.'){
          antennas.add(new Antenna(i, j, frequency));
        }
      }
    }
    return antennas;
  }

  private void addAntinodes(Set<String> antinodes, Antenna antenna1, Antenna antenna2){
    int deltaX = antenna2.x() - antenna1.x();
    int deltaY = antenna2.y() - antenna1.y();
    int antinodeX1 = antenna1.x() - deltaX;
    int antinodeY1 = antenna1.y() - deltaY;
    int antinodeX2 = antenna2.x() + deltaX;
    int antinodeY2 = antenna2.y() + deltaY;

    if(isWithinBounds(antinodeX1, antinodeY1)){
      antinodes.add(antinodeX1 + "," + antinodeY1);
    }

    if(isWithinBounds(antinodeX2, antinodeY2)){
      antinodes.add(antinodeX2 + "," + antinodeY2);
    }
  }

  private void addAntinodesWithHarmonicResonance(Set<String> antinodes, Antenna antenna1, Antenna antenna2){
    int deltaX = antenna2.x() - antenna1.x();
    int deltaY = antenna2.y() - antenna1.y();

    // Add the positions of the antennas themselves if they are in line with each other
    antinodes.add(antenna1.x() + "," + antenna1.y());
    antinodes.add(antenna2.x() + "," + antenna2.y());

    for(int i = 1; i < Math.max(rows, cols); i++){
      int antinodeX1 = antenna1.x() - i * deltaX;
      int antinodeY1 = antenna1.y() - i * deltaY;
      int antinodeX2 = antenna2.x() + i * deltaX;
      int antinodeY2 = antenna2.y() + i * deltaY;

      if(isWithinBounds(antinodeX1, antinodeY1)){
        antinodes.add(antinodeX1 + "," + antinodeY1);
      }

      if(isWithinBounds(antinodeX2, antinodeY2)){
        antinodes.add(antinodeX2 + "," + antinodeY2);
      }
    }
  }

  private boolean isWithinBounds(int x, int y){
    return x >= 0 && x < rows && y >= 0 && y < cols;
  }
}
