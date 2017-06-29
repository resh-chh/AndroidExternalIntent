package com.xyz.externai_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstNumber extends AppCompatActivity {

    EditText etFirstNumber;
    Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_number);

        etFirstNumber= (EditText)findViewById(R.id.etFirstNumber);
        btnSendData= (Button) findViewById(R.id.btnSendData);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etFirstNumber.getText().toString().length() == 0) {
                    etFirstNumber.setError("Enter a number");
                    etFirstNumber.requestFocus();
                    return;
                }
                String number = etFirstNumber.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("NUMBER", number);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

}
    }