package com.ramusthastudio.test1;

import java.util.Comparator;
import java.util.List;

public final class exTest1 {
  private exTest1() {}

  public static void main(String[] args) {
    AgeGenerator gen = new AgeGenerator();
    gen.writeToFile(500000, "resources/unsorted.txt");

    List<String> unsorted = gen.readFromFile("resources/unsorted.txt");
    unsorted.sort(Comparator.comparing(Integer::valueOf));

    gen.writeToFile(unsorted, "resources/sorted.txt");
  }
}
