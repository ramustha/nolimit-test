package com.ramusthastudio.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

final class AgeGenerator {
  private static int randomAge(int aMixAge, int aMaxAge) {
    return ThreadLocalRandom.current().nextInt(aMixAge, aMaxAge + 1);
  }

  public AgeGenerator() {}

  public void writeToFile(Iterable<String> aIterable, String aToPath) {
    try {
      // root of resources (must be added to Project Structure Modules Dependencies)
      Path file = Paths.get(aToPath);
      Files.write(file, aIterable, Charset.defaultCharset());
    } catch (IOException aE) {
      aE.printStackTrace();
    }
  }

  public void writeToFile(int aSize, String aToPath) {
    try {
      // root of resources (must be added to Project Structure Modules Dependencies)
      Path file = Paths.get(aToPath);
      BufferedWriter buff = Files.newBufferedWriter(file, Charset.defaultCharset());

      for (int i = 0; i < aSize; i++) {
        buff.write(Integer.toString(randomAge(1, 100)));
        buff.newLine();
      }

      buff.flush();
      buff.close();
    } catch (IOException aE) {
      aE.printStackTrace();
    }
  }

  public List<String> readFromFile(String aPath) {
    List<String> list = new ArrayList<>();

    try {
      // root of resources (must be added to Project Structure Modules Dependencies)
      Path path = Paths.get(aPath);
      BufferedReader buff = Files.newBufferedReader(path, Charset.defaultCharset());
      for (String line; (line = buff.readLine()) != null; ) {
        list.add(String.valueOf(line));
      }

      buff.close();
    } catch (IOException aE) {
      aE.printStackTrace();
    }

    return list;
  }
}