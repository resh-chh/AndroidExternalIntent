package com.xyz.externai_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnFirstNumber, btnSecondNumber, btnResult;
    TextView txtAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnswer= (TextView)findViewById(R.id.txtAnswer);
        btnFirstNumber=(Button)findViewById(R.id.btnFirstNumber);
        btnSecondNumber=(Button) findViewById(R.id.btnSecondNumber);
        btnResult=(Button)findViewById(R.id.btnResult);

        btnSecondNumber.setEnabled(false);
        btnResult.setEnabled(false);

        btnFirstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, FirstNumber.class);
                startActivityForResult(intent, 100);

            }
        });

        btnSecondNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this, SecondNumber.class);
                startActivityForResult(intent, 200);

            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstNumber= btnFirstNumber.getText().toString();
                double n1= Double.parseDouble(firstNumber);
                String secondNumber= btnFirstNumber.getText().toString();
                double n2= Double.parseDouble(secondNumber);

                double result= n1+n2;
                txtAnswer.setText("Result= " + result);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
            if (data != null) {
                String msg = data.getStringExtra("NUMBER");
                btnFirstNumber.setText(msg);
            }
            btnSecondNumber.setEnabled(true);
        }


        if (requestCode == 200) {
            if (data != null) {
                String msg = data.getStringExtra("NUMBER");
                btnSecondNumber.setText(msg);
            }
            btnResult.setEnabled(true);
        }
    }
    }
}
