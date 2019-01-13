package com.example.complexnumcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inNumberFirstRe, inNumberSecondRe, inNumberFirstIm, inNumberSecondIm;
    Button buttonPlus, buttonMinus, buttonMult, buttonDiv;
    TextView textResult;
    String sign = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating menu


        inNumberFirstRe = (EditText) findViewById(R.id.numRe1);
        inNumberFirstIm = (EditText) findViewById(R.id.numIm1);
        inNumberSecondRe = (EditText) findViewById(R.id.numRe2);
        inNumberSecondIm = (EditText) findViewById(R.id.numIm2);


        buttonPlus = (Button) findViewById(R.id.btnPlus);
        buttonMinus = (Button) findViewById(R.id.btnMinus);
        buttonMult = (Button) findViewById(R.id.btnMult);
        buttonDiv = (Button) findViewById(R.id.btnDiv);

        textResult = (TextView) findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);

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

    public void onClick(View view) {

        double numberFirstRe = 0, numberSecondRe = 0, numberFirstIm = 0, numberSecondIm = 0;
        String resultString = null;

        if (TextUtils.isEmpty(inNumberFirstRe.getText().toString()) || TextUtils.isEmpty(inNumberSecondRe.getText().toString()) ||
                TextUtils.isEmpty(inNumberFirstIm.getText().toString()) || TextUtils.isEmpty(inNumberSecondIm.getText().toString())) {
            return;
        }
        numberFirstRe = Double.parseDouble(inNumberFirstRe.getText().toString());
        numberFirstIm = Double.parseDouble(inNumberFirstIm.getText().toString());
        numberSecondRe = Double.parseDouble(inNumberSecondRe.getText().toString());
        numberSecondIm = Double.parseDouble(inNumberSecondIm.getText().toString());

        Complex complex1 = new Complex(numberFirstRe, numberFirstIm);
        Complex complex2 = new Complex(numberSecondRe, numberSecondIm);


        switch (view.getId()) {
                case R.id.btnPlus:
                    sign = "+";
                    resultString = Complex.sum(complex1, complex2).toString();
                    break;
                case R.id.btnMinus:
                    sign = "-";
                    resultString = Complex.minus(complex1, complex2).toString();
                    break;
                case R.id.btnMult:
                    sign = "*";
                    resultString = Complex.multiplication(complex1, complex2).toString();
                    break;
                case R.id.btnDiv:
            if (numberSecondRe == 0.0 && numberSecondIm == 0){
             Toast.makeText(this,"На ноль делить нельзя", Toast.LENGTH_SHORT).show();
             break;
             }
            else
            sign = "/";
            resultString = Complex.div(complex1, complex2).toString();
             break;
             default:
             break;
        }
        if(view.getId() == R.id.btnDiv && numberSecondRe == 0.0 && numberSecondIm == 0.0 ){
             textResult.setText("error");
            }
             else
            textResult.setText(resultString);
        }
    }

