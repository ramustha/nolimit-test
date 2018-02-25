package com.ramusthastudio.test2.models;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class People implements Serializable {
  private String name;
  private String height;
  private String mass;

  @SerializedName("hair_color")
  private String hairColor;
  @SerializedName("skin_color")
  private String skinColor;
  @SerializedName("eye_color")
  private String eyeColor;
  @SerializedName("birth_year")
  private String birthYear;

  private String gender;
  private String homeworld;

  @SerializedName("films")
  private List<String> filmsUrls;
  @SerializedName("species")
  private List<String> speciesUrls;
  @SerializedName("vehicles")
  private List<String> vehiclesUrls;
  @SerializedName("starships")
  private List<String> starshipsUrls;

  private String created;
  private String edited;
  private String url;

  public String getName() { return name; }
  public String getHeight() { return height; }
  public String getMass() { return mass; }
  public String getHairColor() { return hairColor; }
  public String getSkinColor() { return skinColor; }
  public String getEyeColor() { return eyeColor; }
  public String getBirthYear() { return birthYear; }
  public String getGender() { return gender; }
  public String getHomeworld() { return homeworld; }
  public List<String> getFilmsUrls() { return filmsUrls; }
  public List<String> getSpeciesUrls() { return speciesUrls; }
  public List<String> getVehiclesUrls() { return vehiclesUrls; }
  public List<String> getStarshipsUrls() { return starshipsUrls; }
  public String getCreated() { return created; }
  public String getEdited() { return edited; }
  public String getUrl() { return url; }

  @Override
  public String toString() {
    return new GsonBuilder().create().toJson(this);
  }
}
