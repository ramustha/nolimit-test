package com.ramusthastudio.test3.db;

import java.util.List;

public interface Repository<T> {
  boolean doSave(T aData);
  boolean doSave(List<T> aDatas);
}
