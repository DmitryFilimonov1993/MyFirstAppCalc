package com.example.complexnumcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent;
        switch (item.getItemId()){

            case 1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, expNotationActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, ConverterActivity.class);
                startActivity(intent);
                break;
            case 4:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}
