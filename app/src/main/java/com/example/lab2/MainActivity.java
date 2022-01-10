package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button detail, view;
    TextView n,n1,n2,n3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detail = findViewById(R.id.btn);
        view = findViewById(R.id.btn1);
        n = findViewById(R.id.text);
        n1 = findViewById(R.id.text1);
        n2= findViewById(R.id.text2);
        n3= findViewById(R.id.text3);

        //explicit intent
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                startActivityForResult(i, 8);
            }
        });

        //implicit intent
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 8 && resultCode == RESULT_OK){
            String val = data.getStringExtra("name");
            String val1 = data.getStringExtra("address");
            String val2 = data.getStringExtra("contact");
            String val3 = data.getStringExtra("email");
            n.setText(val);
            n1.setText(val1);
            n2.setText(val2);
            n3.setText(val3);
        }
    }
}