package com.ramusthastudio.test2;

import com.ramusthastudio.test2.models.People;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class exTest2 {
  private exTest2() {}

  public static void main(String[] args) throws InterruptedException, IOException {
    SwapiApp swapiApp = new SwapiApp();

    int i = 1;
    while (i <= 5) {
      // request swapi 1 - 5 page
      swapiApp.requestPeople(i);
      i++;
    }

    // wait until request done
    Thread.sleep(10000);

    // iterate result
    Map<String, List<People>> peopleGroup = swapiApp.getPeopleGroup();
    peopleGroup.forEach((key, aPeopleList) ->
    {
      System.out.printf("key %s, size %d, %s \n", key, aPeopleList.size(), aPeopleList);

      // write to file
      swapiApp.writeGroupToJSONFile(aPeopleList, 1);
    });

    System.exit(0);
  }
}
