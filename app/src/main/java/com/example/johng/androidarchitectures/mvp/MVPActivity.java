package com.example.johng.androidarchitectures.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.johng.androidarchitectures.R;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        setTitle(R.string.titleForMVPActivity);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MVPActivity.class);
    }
}
