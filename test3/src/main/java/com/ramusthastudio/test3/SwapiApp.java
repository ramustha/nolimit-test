package com.ramusthastudio.test3;

import com.ramusthastudio.test3.db.PeopleRepository;
import com.ramusthastudio.test3.db.Repository;
import com.ramusthastudio.test3.models.People;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.jooq.DSLContext;
import org.jooq.tools.json.JSONArray;
import org.jooq.tools.json.JSONObject;
import org.jooq.tools.json.JSONParser;
import org.jooq.tools.json.ParseException;

public final class SwapiApp {
  private final Repository<People> fRepository;

  public SwapiApp(DSLContext aDSLContext) {
    fRepository = new PeopleRepository(aDSLContext);
  }

  @SuppressWarnings("unchecked")
  public List<People> readFromJSONFile() {
    List<People> peopleList = new ArrayList<>();

    // root of resources (must be added to Project Structure Modules Dependencies)
    try (Stream<Path> paths = Files.walk(Paths.get("resources/swapi"))) {
      paths
          .filter(Files::isRegularFile)
          .forEach(aPath -> {

            try (BufferedReader buff = Files.newBufferedReader(aPath, Charset.defaultCharset())) {

              for (String line; (line = buff.readLine()) != null; ) {
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(new StringReader(line));
                jsonArray.forEach(object -> {
                  JSONObject jo = (JSONObject) object;
                  peopleList.add(new People(
                      jo.get("name").toString(),
                      jo.get("gender").toString(),
                      jo.get("homeworld").toString()));
                });
              }

              buff.close();
            } catch (IOException | ParseException aE) {
              aE.printStackTrace();
            }
          });
    } catch (IOException aE) {
      aE.printStackTrace();
    }

    return peopleList;
  }

  public boolean doSave(List<People> aPeopleList) {
    return fRepository.doSave(aPeopleList);
  }
}
