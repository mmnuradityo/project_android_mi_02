package com.amikom.two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    EditText edtNim;
    EditText edtPassword;
    Button btnLogin;
    String nim = "18.02.1234";
    String password = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("onCreate", "mulai");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtNim = findViewById(R.id.edt_nim);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnLogin.setOnLongClickListener(this);
        Log.e("onCreate", "selesai");
    }

    @Override
    public void onClick(View view) {
        Log.e("onClick", "mulai");
        if (nim.equals(edtNim.getText().toString())
            && password.equals(edtPassword.getText().toString()) ) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
        }
        Log.e("onClick", "selesai");
    }

    @Override
    protected void onStart() {
        Log.e("onStart", "mulai");
        super.onStart();
        Log.e("onStart", "selesai");
    }

    @Override
    protected void onRestart() {
        Log.e("onRestart", "mulai");
        super.onRestart();
        Log.e("onRestart", "selesai");
    }

    @Override
    protected void onResume() {
        Log.e("onResume", "mulai");
        super.onResume();
        Log.e("onResume", "selesai");
    }

    @Override
    protected void onPause() {
        Log.e("onPause", "mulai");
        super.onPause();
        Log.e("onPause", "selesai");
    }

    @Override
    protected void onStop() {
        Log.e("onStop", "mulai");
        super.onStop();
        Log.e("onStop", "selesai");
    }

    @Override
    protected void onDestroy() {
        Log.e("onDestroy", "mulai");
        super.onDestroy();
        Log.e("onDestroy", "selesai");
    }

    @Override
    public boolean onLongClick(View view) {
        Log.e("onLongClick", "mulai");
        Toast.makeText(this, "Jangan ditekan lama-lama", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return false;
    }
}
