package com.example.johng.androidarchitectures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.johng.androidarchitectures.mvc.MVCActivity;
import com.example.johng.androidarchitectures.mvp.MVPActivity;
import com.example.johng.androidarchitectures.mvvvm.MVVMActivity;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view) {
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP(View view) {
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view) {
        startActivity(MVVMActivity.getIntent(this));
    }


}
