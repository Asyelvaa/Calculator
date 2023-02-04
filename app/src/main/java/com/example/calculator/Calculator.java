package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private EditText etfirst,etsecond;
    private Button btnadd,btnsubs,btnmply,btndvd,clear;
    Double num1, num2;
    TextView tvresult, TxtErrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        etfirst = findViewById(R.id.first);
        etsecond = findViewById(R.id.second);
        btnadd = findViewById(R.id.btnadd);
        btnsubs = findViewById(R.id.btnsubs);
        btnmply = findViewById(R.id.btnmply);
        btndvd = findViewById(R.id.btndvd);
        tvresult = findViewById(R.id.result);
        TxtErrors = findViewById(R.id.TxtError);
        clear = findViewById(R.id.clear);
        Clicklistener();

        etfirst.addTextChangedListener(TxtWathcher);
        etsecond.addTextChangedListener(TxtWathcher);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etfirst.getText().clear();
                etsecond.getText().clear();
            }
        });
    }

    private TextWatcher TxtWathcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String firstNum = etfirst.getText().toString().trim();
            String ScndNum = etsecond.getText().toString().trim();
            {
                btnadd.setEnabled(!firstNum.isEmpty() && !ScndNum.isEmpty());
                btnsubs.setEnabled(!firstNum.isEmpty() && !ScndNum.isEmpty());
                btnmply.setEnabled(!firstNum.isEmpty() && !ScndNum.isEmpty());
                btndvd.setEnabled(!firstNum.isEmpty() && !ScndNum.isEmpty());
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public void Clicklistener() {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Double.parseDouble(etfirst.getText().toString());
                num2 = Double.parseDouble(etsecond.getText().toString());
                Double result = num1 + num2;
                tvresult.setText(String.valueOf(result));
            }
        });
//        if (TextUtils.isEmpty(etfirst.getText().toString())) {
//            TxtErrors.setText("Please input the number..");
//            Toast.makeText(getApplicationContext(), "Masukin nomer woi", Toast.LENGTH_SHORT).show();
//        } else {
            btnsubs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Double.parseDouble(etfirst.getText().toString());
                    num2 = Double.parseDouble(etsecond.getText().toString());
                    Double result = num1 - num2;
                    tvresult.setText(String.valueOf(result));
                }
            });
            btnmply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Double.parseDouble(etfirst.getText().toString());
                    num2 = Double.parseDouble(etsecond.getText().toString());
                    Double result = num1 * num2;
                    tvresult.setText(String.valueOf(result));
                }
            });
            btndvd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Double.parseDouble(etfirst.getText().toString());
                    num2 = Double.parseDouble(etsecond.getText().toString());
                    Double result = num1 / num2;
                    tvresult.setText(String.valueOf(result));
                }
            });
        }
    }
//    }
