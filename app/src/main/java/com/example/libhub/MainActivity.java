package com.example.libhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnborrow, btnsearch, btnreturn, btnprofile ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnborrow = (Button) findViewById(R.id.btnborrow);
        btnprofile = (Button) findViewById(R.id.btnprofile);
        btnreturn = (Button) findViewById(R.id.btnreturn);
        btnsearch = (Button) findViewById(R.id.btnsearch);

        btnborrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Borrow_Activity.class);
                startActivity(intent);
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, search_activity.class);
                startActivity(intent);
            }
        });
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReturnActivity.class);
                startActivity(intent);
            }
        });



    }
}
