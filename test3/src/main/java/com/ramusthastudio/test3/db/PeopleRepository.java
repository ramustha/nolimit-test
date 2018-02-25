package com.ramusthastudio.test3.db;

import com.ramusthastudio.test3.Tables;
import com.ramusthastudio.test3.models.People;
import com.ramusthastudio.test3.tables.Swapi;
import java.util.List;
import org.jooq.DSLContext;

public final class PeopleRepository implements Repository<People> {
  private final Swapi T = Tables.SWAPI;
  private final DSLContext fDSLContext;
  public PeopleRepository(final DSLContext aContext) {
    fDSLContext = aContext;
  }

  @Override
  public boolean doSave(People aData) {
    return aData != null &&
        fDSLContext
            .insertInto(T)
            .set(T.NAME, aData.getName())
            .set(T.GENDER, aData.getGender())
            .set(T.HOMEWORLD, aData.getHomeworld())
            .execute() == 1;

  }

  @Override
  public boolean doSave(List<People> aDatas) {
    for (People data : aDatas) {
      if (!doSave(data)) {
        return false;
      }
    }
    return true;
  }
}
