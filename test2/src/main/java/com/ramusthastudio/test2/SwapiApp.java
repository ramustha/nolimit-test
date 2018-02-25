package com.ramusthastudio.test2;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ramusthastudio.test2.api.Swapi;
import com.ramusthastudio.test2.api.SwapiApi;
import com.ramusthastudio.test2.models.People;
import com.ramusthastudio.test2.models.SwapiList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class SwapiApp implements Callback<SwapiList<People>> {
  private final Map<String, List<People>> fPeopleGroup = new HashMap<>();

  public SwapiApp() { }

  public Map<String, List<People>> getPeopleGroup() { return fPeopleGroup; }

  public void requestPeople(int aPage) {
    Swapi service = SwapiApi.instance();

    Call<SwapiList<People>> getAllPeople = service.getAllPeople(aPage);
    getAllPeople.enqueue(this);
  }

  public List<People> writeGroupToJSONFile(List<People> aPeopleList, int aPage) {
    if (aPeopleList.isEmpty()) {
      return null;
    }

    int max = 15; /* max 15 data for a single file json */
    if (aPeopleList.size() < max) {
      writeToJSONFile(aPeopleList, aPage);
    } else {
      List<People> maxList = aPeopleList.subList(0, max);
      writeToJSONFile(maxList, aPage);

      List<People> nextList = aPeopleList.subList(max, aPeopleList.size());
      return writeGroupToJSONFile(nextList, aPage + 1);
    }

    return null;
  }

  public List<People> readFromJSONFile() {
    List<People> peopleList = new ArrayList<>();

    // root of resources (must be added to Project Structure Modules Dependencies)
    try (Stream<Path> paths = Files.walk(Paths.get("resources/swapi"))) {
      paths
          .filter(Files::isRegularFile)
          .forEach(aPath -> {

            try (BufferedReader buff = Files.newBufferedReader(aPath, Charset.defaultCharset())) {

              for (String line; (line = buff.readLine()) != null; ) {
                Type type = new TypeToken<List<People>>() {}.getType();
                peopleList.addAll(new GsonBuilder().create().fromJson(line, type));
              }

              buff.close();
            } catch (IOException aE) {
              aE.printStackTrace();
            }
          });
    } catch (IOException aE) {
      aE.printStackTrace();
    }

    return peopleList;
  }

  private static void writeToJSONFile(List<People> aPeopleList, int aPage) {
    // root of resources (must be added to Project Structure Modules Dependencies)
    // [homeworld]_[gender]_[random_string]_[page].json
    Path file = Paths.get("resources/swapi/" + pathNameBuilder(aPeopleList.get(0)) + "_" + aPage + ".json");
    try (BufferedWriter buff = Files.newBufferedWriter(file, Charset.defaultCharset())) {
      buff.write(aPeopleList.toString());
      buff.flush();
      buff.close();
    } catch (IOException aE) {
      aE.printStackTrace();
    }
  }

  private static String pathNameBuilder(People aPeople) {
    String gender = aPeople.getGender().replace("n/a", "na");  /* replace ilegal char */
    String homeworld = URI.create(aPeople.getHomeworld()).getPath().replace("/", "_");  /* replace ilegal char */
    String randomString = String.valueOf(System.currentTimeMillis());
    return homeworld + "_" + gender + "_" + randomString + "_";
  }

  private void groupByHomeWordAndGender(List<People> aPeopleList) {
    aPeopleList.forEach(aPeople ->
        {
          String gender = aPeople.getGender();
          String homeworld = aPeople.getHomeworld();
          String key = homeworld + gender;

          if (!fPeopleGroup.containsKey(key)) {
            List<People> newGroupPeopleList = new ArrayList<>();
            newGroupPeopleList.add(aPeople);
            fPeopleGroup.put(key, newGroupPeopleList);
          } else {
            fPeopleGroup.get(key).add(aPeople);
          }
        }
    );
  }

  @Override
  public void onResponse(Call<SwapiList<People>> aCall, Response<SwapiList<People>> aResponse) {
    if (!aCall.isCanceled()) {
      if (aResponse.isSuccessful()) {
        SwapiList<People> resBody = aResponse.body();
        if (resBody != null && resBody.getResults() != null) {
          groupByHomeWordAndGender(resBody.getResults());
        }
      }
    }
  }

  @Override
  public void onFailure(Call<SwapiList<People>> aCall, Throwable aThrowable) {
    aCall.cancel();
    aThrowable.printStackTrace();
  }
}
