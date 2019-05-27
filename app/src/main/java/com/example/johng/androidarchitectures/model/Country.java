package com.example.johng.androidarchitectures.model;

import com.google.gson.annotations.SerializedName;


/*
* URL url https://restcountries.eu/rest/v2/
* this is using Json with the retrofit to parse for name
* "[{"name":"Afghanistan"," from URL
*/

public class Country {
    @SerializedName("name")
    public String countryName;
}
