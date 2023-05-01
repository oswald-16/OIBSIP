package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_player_name extends AppCompatActivity {
    Button button;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player_name);

        button=findViewById(R.id.btnStart);
        editText1=findViewById(R.id.txtP1);
        editText2=findViewById(R.id.txtP2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(add_player_name.this,gameActivity.class);
                intent.putExtra("Name1",editText1.getText().toString());
                intent.putExtra("Name2",editText2.getText().toString());
                Toast.makeText(add_player_name.this, "All The Best!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}