package com.ramusthastudio.test3.models;

import java.io.Serializable;

public class People implements Serializable {
  private int id;
  private final String name;
  private final String gender;
  private final String homeworld;

  public People(String aName, String aGender, String aHomeworld) {
    name = aName;
    gender = aGender;
    homeworld = aHomeworld;
  }

  public int getId() { return id; }
  public String getName() { return name; }
  public String getGender() { return gender; }
  public String getHomeworld() { return homeworld; }
}
