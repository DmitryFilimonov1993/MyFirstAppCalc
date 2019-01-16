package com.example.user.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNumberFirstReal,
            inNumberSecondRe,
            inNumberFirstIm,
            inNumberSecondIm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating menu
        inputNumberFirstReal = (EditText) findViewById(R.id.first_real_number_edit_text);
        inNumberFirstIm = (EditText) findViewById(R.id.second_real_number_edit_text);
        inNumberSecondRe = (EditText) findViewById(R.id.numRe2);
        inNumberSecondIm = (EditText) findViewById(R.id.numIm2);

        ((Button) findViewById(R.id.btnPlus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMinus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMult)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnDiv)).setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        //TODO stings to resources
        menu.add(0, 1, 0, "Algebraic notation");
        menu.add(0, 2, 0, "Exponential notation");
        menu.add(0, 3, 0, "Converter");
        menu.add(0, 4, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

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

        if (TextUtils.isEmpty(inputNumberFirstReal.getText().toString()) ||
                TextUtils.isEmpty(inNumberSecondRe.getText().toString()) ||
                TextUtils.isEmpty(inNumberFirstIm.getText().toString()) ||
                TextUtils.isEmpty(inNumberSecondIm.getText().toString()))
            return;

        String resultString = calculateResultString(view.getId());
        
        TextView resultView = (TextView) findViewById(R.id.textResult);

        if (resultView != null)
            resultView.setText(resultString);
    }

    private String calculateResultString(int viewID) {

        double numberFirstRe, numberSecondRe, numberFirstIm, numberSecondIm;

        numberFirstRe = Double.parseDouble(inputNumberFirstReal.getText().toString());
        numberFirstIm = Double.parseDouble(inNumberFirstIm.getText().toString());
        numberSecondRe = Double.parseDouble(inNumberSecondRe.getText().toString());
        numberSecondIm = Double.parseDouble(inNumberSecondIm.getText().toString());

        Complex complexFirst = new Complex(numberFirstRe, numberFirstIm);
        Complex complexSecond = new Complex(numberSecondRe, numberSecondIm);

        //TODO remove this variable
        String sign;

        String resultString = "";

        switch (viewID) {

            case R.id.btnPlus:
                sign = "+";
                resultString = Complex.sum(complexFirst, complexSecond).toString();
                break;
            case R.id.btnMinus:
                sign = "-";
                resultString = Complex.minus(complexFirst, complexSecond).toString();
                break;
            case R.id.btnMult:
                sign = "*";
                resultString = Complex.multiplication(complexFirst, complexSecond).toString();
                break;
            case R.id.btnDiv:
                if (numberSecondRe == 0.0 && numberSecondIm == 0) {
                    resultString = getString(R.string.division_by_zero_error);
                    break;
                } else
                    sign = "/";
                resultString = Complex.div(complexFirst, complexSecond).toString();
                break;
            default:
                break;
        }

        return resultString;
    }
}

