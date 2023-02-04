package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String USERNAME_KEY = "username_key";
    public static final String PASSWORD_KEY = "password_key";

    // variable for shared preferences.
    SharedPreferences sharedpreferences;
    String username, password;
    //list widget yang akan dikenakan aksi
    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect semua komponen dengan xmlnya
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnPassword);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        username = sharedpreferences.getString(USERNAME_KEY, null);
        password = sharedpreferences.getString(PASSWORD_KEY, null);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                if (username.equalsIgnoreCase("admin") &&
                        password.equalsIgnoreCase("admin")){


                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(USERNAME_KEY, txtUsername.getText().toString());
                    editor.putString(PASSWORD_KEY, txtPassword.getText().toString());

                    // to save our data with key and value.
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, Calculator.class));
                    finish();
////                    Toast.makeText(getApplicationContext(), "Sukses Login", Toast.LENGTH_SHORT).show();
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("Sukses")
//                            .setMessage("Login Sukses")
//                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    Intent intent = new Intent(MainActivity.this, Calculator.class);
//                                    startActivity(intent);
//                                }
//                            })
//                            // A null listener allows the button to dismiss the dialog and take no further action.
//                            .setNegativeButton(android.R.string.no, null)
//                            .setIcon(android.R.drawable.ic_dialog_alert)
//                            .show();
                }else{
                    Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}