package com.example.johng.androidarchitectures.mvc;

import com.example.johng.androidarchitectures.model.CountriesService;
import com.example.johng.androidarchitectures.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

//handles business logic:

//the business logic is the portable part of an application,
//if you were to re-implement this in IOS then this is the
//part of the project you would like to stay the same.

//anything that does not pertain to the viewing of the data

//handles the specifics of validation and control flow:
// if less then 1 do this if not do that

public class CountriesController {

    //drawback is that we refer to the view here and cannot change
    //the view to another view very easily
    //depends on the view having methods setValues and OnError/
    //everything you will add to the controller over time.

    private MVCActivity view;
    private CountriesService service;

    public CountriesController(MVCActivity view){
        this.view = view;
        service = new CountriesService();
        fetchCountries();
    }

    private void fetchCountries(){
        service.getCounties()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(List<Country> value) {
                        List<String> countryNames = new ArrayList<>();

                        for(Country country: value) {
                            countryNames.add(country.countryName);
                        }
                        view.setValues(countryNames);

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError();
                    }
                });
    }

    public void onRefresh() {
        fetchCountries();
    }

}
