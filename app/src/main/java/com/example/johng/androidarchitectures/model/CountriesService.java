package com.example.johng.androidarchitectures.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {
    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private CountriesApi api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(CountriesApi.class);
    }

    //this is what you would call in the model to get the countries

    public Single<List<Country>> getCounties() {
        return api.getCountries();
    }
}
