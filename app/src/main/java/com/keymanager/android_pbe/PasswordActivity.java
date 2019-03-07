package com.keymanager.android_pbe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    private EditText edtPassword;
    private TextView output;
    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        output = (TextView) findViewById(R.id.output);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] salt = "PveFT7isDjGYFTaYhc2Fzw==".getBytes();
                String data = Crypto.deriveKeyPbkdfData(salt, edtPassword.getText().toString());
                output.setText("Output Hash is::" + data);
            }
        });
    }
}
