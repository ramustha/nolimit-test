package com.ramusthastudio.test3;

import com.ramusthastudio.test3.db.DataSourceFactory;
import com.ramusthastudio.test3.models.People;
import java.util.List;
import org.jooq.DSLContext;

public final class exTest3 {
  private exTest3() {}

  public static void main(String[] args) throws Exception {
    DSLContext context = DataSourceFactory.connect();
    SwapiApp app = new SwapiApp(context);
    List<People> peopleList = app.readFromJSONFile();
    app.doSave(peopleList);

    DataSourceFactory.disconnect();
    System.exit(0);
  }
}
