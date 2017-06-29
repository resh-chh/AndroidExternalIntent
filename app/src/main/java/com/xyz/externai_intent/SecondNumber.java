package com.xyz.externai_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondNumber extends AppCompatActivity {

    EditText etSecondNumber;
    Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_number);

        etSecondNumber= (EditText)findViewById(R.id.etSecondNumber);
        btnSendData= (Button) findViewById(R.id.btnSendData);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etSecondNumber.getText().toString().length()==0){
                    etSecondNumber.setError("Enter a number");
                    etSecondNumber.requestFocus();
                    return;
                }
            String number= etSecondNumber.getText().toString();
                Intent intent= new Intent();
                intent.putExtra("NUMBER", number);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
}
