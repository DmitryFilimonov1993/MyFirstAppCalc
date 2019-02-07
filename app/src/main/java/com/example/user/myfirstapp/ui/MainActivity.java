package com.example.user.myfirstapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.*;

import com.example.user.myfirstapp.R;
import com.example.user.myfirstapp.helpers.IntentsHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNumberFirstReal,
            inputNumberSecondReal,
            inputNumberFirstImage,
            inputNumberSecondImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating menu

        inputNumberFirstReal = (EditText) findViewById(R.id.first_real_number_edit_text);
        inputNumberSecondReal = (EditText) findViewById(R.id.second_real_number_edit_text);
        inputNumberFirstImage = (EditText) findViewById(R.id.first_image_number_edit_text);
        inputNumberSecondImage = (EditText) findViewById(R.id.second_image_number_edit_text);

        ((Button) findViewById(R.id.buttonPlus)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonMinus)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonMultiplication)).setOnClickListener(this);
        ((Button) findViewById(R.id.buttonDivision)).setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 0, R.string.algebraic_notation);
        menu.add(0, 2, 0, R.string.exponential_notation);
        menu.add(0, 3, 0, R.string.converter);
        menu.add(0, 4, 0, R.string.quit);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1:
                IntentsHelper.startNewActivity(this, MainActivity.class);
                break;
            case 2:
                IntentsHelper.startNewActivity(this, expNotationActivity.class);
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

    public void onClick(View view) {

        if (TextUtils.isEmpty(inputNumberFirstReal.getText().toString()) ||
                TextUtils.isEmpty(inputNumberFirstImage.getText().toString()) ||
                TextUtils.isEmpty(inputNumberSecondReal.getText().toString()) ||
                TextUtils.isEmpty(inputNumberSecondImage.getText().toString()))
            return;

        String resultString = calculateResultString(view.getId());

        TextView resultView = (TextView) findViewById(R.id.textResult);

        if (resultView != null)
            resultView.setText(resultString);
    }

    private String calculateResultString(int viewID) {

        double numberFirstRe, numberSecondRe, numberFirstIm, numberSecondIm;

        numberFirstRe = Double.parseDouble(inputNumberFirstReal.getText().toString());
        numberFirstIm = Double.parseDouble(inputNumberFirstImage.getText().toString());
        numberSecondRe = Double.parseDouble(inputNumberSecondReal.getText().toString());
        numberSecondIm = Double.parseDouble(inputNumberSecondImage.getText().toString());

        Complex complexFirst = new Complex(numberFirstRe, numberFirstIm);
        Complex complexSecond = new Complex(numberSecondRe, numberSecondIm);

        String resultString = "";

        switch (viewID) {

            case R.id.buttonPlus:

                resultString = Complex.sum(complexFirst, complexSecond).toString();
                break;

            case R.id.buttonMinus:

                resultString = Complex.minus(complexFirst, complexSecond).toString();
                break;

            case R.id.buttonMultiplication:

                resultString = Complex.multiplication(complexFirst, complexSecond).toString();
                break;

            case R.id.buttonDivision:

                if (numberSecondRe == 0.0 && numberSecondIm == 0) {
                    resultString = getString(R.string.division_by_zero_error);
                    break;
                } else

                resultString = Complex.div(complexFirst, complexSecond).toString();
                break;

            default:
                break;
        }

        return resultString;
    }
}

