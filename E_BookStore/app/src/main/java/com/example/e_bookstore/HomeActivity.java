package com.example.e_bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        i1=findViewById(R.id.book1);
        i2=findViewById(R.id.book2);
        i3=findViewById(R.id.book3);
        i4=findViewById(R.id.book4);
        i5=findViewById(R.id.book5);
        i6=findViewById(R.id.book6);
        i7=findViewById(R.id.book7);
        i8=findViewById(R.id.book8);
        i9=findViewById(R.id.book9);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,Book1Activity.class);
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,Book2Activity.class);
                startActivity(intent);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,Book3Activity.class);
                startActivity(intent);
            }
        });
    }
}