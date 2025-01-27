package com.bicubic.gincana.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    //    public static final String BASE_URL = "http://api.themoviedb.org/3/";
//    public static final String BASE_URL = "http://api.stackexchange.com/2.1/";
    public static final String BASE_URL = "http://trialme.in/Ginicana/api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
//                     .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

}
