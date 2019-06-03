package com.example.johng.androidarchitectures.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.johng.androidarchitectures.R;

import java.util.ArrayList;
import java.util.List;

//this is the view in MVC

//handles the view:

//anything that is not validating or controlling the data,
//it simply takes the data from the controller and then displays it.

public class MVCActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    //the major drawback is the link/dependency of controller and
    //the view, so that the controller is tightly coupled to the view
    //meaning they are not very much interchangeable.

    private CountriesController controller;

    private Button retryButton;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle(R.string.titleForMVCActivity);

        //look at constructor, it will fetch and call setValues
        controller = new CountriesController(this);

        list = findViewById(R.id.list);
        retryButton = findViewById(R.id.retryButton);
        progressBar = findViewById(R.id.progress);

        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You clicked " + listValues.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setValues(List<String> values) {
        listValues.clear();
        listValues.addAll(values);
        retryButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        list.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    public void onRetry(View view) {
        controller.onRefresh();
        retryButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        list.setVisibility(View.GONE);
    }

    public void onError() {
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show();
        retryButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
    }

    //intents create activities
    public static Intent getIntent(Context context) {
        return new Intent(context, MVCActivity.class);
    }


}
