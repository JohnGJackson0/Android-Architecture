package com.example.johng.androidarchitectures.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

//this is referred to as the remote

public interface CountriesApi {
    @GET("all")
    Single<List<Country>> getCountries();

}
