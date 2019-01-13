package com.example.user.myfirstapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public boolean onCreateOptionsMenu(Menu menu){

        menu.add("Menu 1");
        menu.add("Menu 2");
        menu.add("Menu 3");
        menu.add("Menu 4");

        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item){

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    TextView textOut;
    Button btnFirst, btnSecond, btnThird, btnForth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        textOut = (TextView) findViewById(R.id.textView);
        btnFirst = (Button) findViewById(R.id.button1);
        btnSecond = (Button) findViewById(R.id.button2);
        btnThird = (Button) findViewById(R.id.button3);
        btnForth = (Button) findViewById(R.id.button4);

        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);
        btnForth.setOnClickListener(this);
    }
        //
        //creat handler
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button1:
                        textOut.setText("Нажата кнопка 1");
                        Toast.makeText(this, "Кнопка 1 нажата", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button2:
                        textOut.setText("Нажата кнопка 2");
                        Toast.makeText(this, "Кнопка 2 нажата", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button3:
                        textOut.setText("Нажата кнопка 3");
                        Toast.makeText(this, "Кнопка 3 нажата", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button4:
                        textOut.setText("Нажата кнопка 4");
                        Toast.makeText(this, "Кнопка 4 нажата", Toast.LENGTH_LONG).show();
                        break;
                }
            }
    }

