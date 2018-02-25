package com.ramusthastudio.test2.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class SwapiApi {
  private static Swapi sSwapi;

  private SwapiApi() { }

  public static Swapi instance() {
    if (sSwapi == null) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

      OkHttpClient httpClient = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("https://swapi.co/api/")
          .client(httpClient)
          .addConverterFactory(GsonConverterFactory.create())
          .build();

      sSwapi = retrofit.create(Swapi.class);
    }
    return sSwapi;
  }
}
