package com.example.johng.androidarchitectures.mvvvm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.johng.androidarchitectures.R;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        setTitle(R.string.titleForMVVMActivity);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVVMActivity.class);
    }
}
