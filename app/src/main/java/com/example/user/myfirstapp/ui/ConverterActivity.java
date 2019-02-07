package com.example.user.myfirstapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.myfirstapp.R;
import com.example.user.myfirstapp.helpers.IntentsHelper;

public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0,1,0, "Algebraic notation");
        menu.add(0,2,0, "Exponential notation");
        menu.add(0,3,0, "Converter");
        menu.add(0,4,0, "Quit");


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1:
                IntentsHelper.startNewActivity(this, MainActivity.class);
                break;
            case 2:
                IntentsHelper.startNewActivity(this, ExpNotationActivity.class);
                break;
            case 3:
                IntentsHelper.startNewActivity(this, ConverterActivity.class);
                break;
            case 4:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}
