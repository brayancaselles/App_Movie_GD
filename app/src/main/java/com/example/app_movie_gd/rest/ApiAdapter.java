package com.example.app_movie_gd.rest;

import com.example.app_movie_gd.interfaces.rest.JsonApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private ApiAdapter() {
    }

    private static JsonApi jsonApi;

    public static JsonApi getDataMovie() {
        if (jsonApi == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .client(new OkHttpClient().newBuilder().build())
                    .baseUrl(Endpoints.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            jsonApi = retrofit.create(JsonApi.class);
        }
        return jsonApi;
    }

}
