package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    EditText na,ad, em, co;
    Button info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info = findViewById(R.id.info);
        na = findViewById(R.id.name);
        ad = findViewById(R.id.address);
        em = findViewById(R.id.contact);
        co = findViewById(R.id.email);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                String fullName =  na.getText().toString();
                String location = ad.getText().toString();
                String email = em.getText().toString();
                String phone = co.getText().toString();
                i.putExtra("name",fullName);
                i.putExtra("address",location);
                i.putExtra("contact",phone);
                i.putExtra("email",email);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}