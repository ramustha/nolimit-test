package com.ramusthastudio.test2.models;

import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.util.ArrayList;

public class SwapiList<T> implements Serializable {
  private int count;
  private String next;
  private String previous;
  private ArrayList<T> results;

  public int getCount() { return count; }
  public String getNext() { return next; }
  public String getPrevious() { return previous; }
  public ArrayList<T> getResults() { return results; }

  public boolean hasMore() {
    return (next != null && next.length() != 0);
  }

  @Override
  public String toString() {
    return new GsonBuilder().create().toJson(this);
  }
}
