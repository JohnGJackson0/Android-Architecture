package com.example.johng.androidarchitectures.mvp;

import com.example.johng.androidarchitectures.model.CountriesService;
import com.example.johng.androidarchitectures.model.Country;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesPresenter {

    private MVPActivity view;
    private CountriesService service;

    public CountriesPresenter(MVPActivity view){
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


    public interface View {
        void setValues(List<String> countries);
        void onError();
    }


}
