package com.example.johng.androidarchitectures.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.johng.androidarchitectures.R;

public class MVCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle(R.string.titleForMVCActivity);
    }

    //intents create activities
    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }


}
