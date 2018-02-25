package com.ramusthastudio.test2.api;

import com.ramusthastudio.test2.models.People;
import com.ramusthastudio.test2.models.SwapiList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Swapi {
  @GET("people/")
  Call<SwapiList<People>> getAllPeople(@Query("page") int page);

  @GET("people/{id}/")
  Call<SwapiList<People>> getPeople(@Path("id") int peopleId);
}
