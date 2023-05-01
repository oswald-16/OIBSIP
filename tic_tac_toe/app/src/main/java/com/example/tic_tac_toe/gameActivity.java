package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class gameActivity extends AppCompatActivity {

    private final List<int[]> combinationlist=new ArrayList<>();
    private int[] gridposition={0,0,0,0,0,0,0,0,0};
    private int playerturnno = 1;
    private int totalselectedgrid=1;
    private TextView t1,t2;
    private LinearLayout person1,person2;
    private ImageView grid1,grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        t1=findViewById(R.id.txtN1);
        t2=findViewById(R.id.txtN2);

        Intent i1=getIntent();
        String N1=i1.getStringExtra("Name1");
        String N2=i1.getStringExtra("Name2");
        t1.setText(N1);
        t2.setText(N2);

        person1=findViewById(R.id.llayout1);
        person2=findViewById(R.id.llayout2);

        grid1=findViewById(R.id.grid1);
        grid2=findViewById(R.id.grid2);
        grid3=findViewById(R.id.grid3);
        grid4=findViewById(R.id.grid4);
        grid5=findViewById(R.id.grid5);
        grid6=findViewById(R.id.grid6);
        grid7=findViewById(R.id.grid7);
        grid8=findViewById(R.id.grid8);
        grid9=findViewById(R.id.grid9);

        combinationlist.add(new int[]{0,1,2});
        combinationlist.add(new int[]{3,4,5});
        combinationlist.add(new int[]{6,7,8});
        combinationlist.add(new int[]{0,3,6});
        combinationlist.add(new int[]{1,4,7});
        combinationlist.add(new int[]{2,5,8});
        combinationlist.add(new int[]{2,4,6});
        combinationlist.add(new int[]{0,4,8});
        //combinationlist.add(new int[]{});

        grid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(0)){
                    playGame((ImageView)view,0);
                }
            }
        });

        grid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(1)){
                    playGame((ImageView)view,1);
                }
            }
        });

        grid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(2)){
                    playGame((ImageView)view,2);
                }
            }
        });

        grid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(3)){
                    playGame((ImageView)view,3);
                }
            }
        });

        grid5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(4)){
                    playGame((ImageView)view,4);
                }
            }
        });

        grid6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(5)){
                    playGame((ImageView)view,5);
                }
            }
        });

        grid7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(6)){
                    playGame((ImageView)view,6);
                }
            }
        });

        grid8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(7)){
                    playGame((ImageView)view,7);
                }
            }
        });

        grid9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGridSelected(8)){
                    playGame((ImageView)view,8);
                }
            }
        });
    }

    private void playGame(ImageView imageView,int selectedgridposition){
        gridposition[selectedgridposition]=playerturnno;
        if(playerturnno==1){
            imageView.setImageResource(R.drawable.cross_image);

            if(checkpersonwin()){
                WinDialog winDialog=new WinDialog(gameActivity.this, t1.getText().toString() + "has won the match",gameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalselectedgrid == 9){
                WinDialog winDialog=new WinDialog(gameActivity.this,"It is a draw!",gameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();

            }
            else{
                changeplayerturn(2);
                totalselectedgrid++;
            }
        }
        else{
            imageView.setImageResource(R.drawable.circle_image);

            if(checkpersonwin()){
                WinDialog winDialog=new WinDialog(gameActivity.this, t2.getText().toString() + " has won the match",gameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(selectedgridposition == 9){
                WinDialog winDialog=new WinDialog(gameActivity.this,"It is a draw!",gameActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else{
                changeplayerturn(1);
                totalselectedgrid++;
            }
        }
    }

    private void changeplayerturn(int currentplayerturn){
        playerturnno=currentplayerturn;

        if(playerturnno == 1){
            person1.setBackgroundResource(R.drawable.back_red_border);
            person2.setBackgroundResource(R.drawable.black_box);
        }

        else{
            person2.setBackgroundResource(R.drawable.back_red_border);
            person1.setBackgroundResource(R.drawable.black_box);
        }


    }

    private boolean checkpersonwin(){
        boolean replay=false;

        for(int i=0;i<combinationlist.size();i++){
            final int[] combo = combinationlist.get(i);

            if(gridposition[combo[0]] == playerturnno && gridposition[combo[1]] == playerturnno && gridposition[combo[2]] == playerturnno){
                replay = true;
            }
        }
        return replay;
    }

    private boolean isGridSelected(int position){
        boolean reply=false;

        if(gridposition[position] == 0){
            reply=true;
        }
        return reply;
    }

    public void restart(){
        gridposition = new int[]{0,0,0,0,0,0,0,0,0};
        playerturnno=1;
        totalselectedgrid=1;

        grid1.setImageResource(R.drawable.whitebox);
        grid2.setImageResource(R.drawable.whitebox);
        grid3.setImageResource(R.drawable.whitebox);
        grid4.setImageResource(R.drawable.whitebox);
        grid5.setImageResource(R.drawable.whitebox);
        grid6.setImageResource(R.drawable.whitebox);
        grid7.setImageResource(R.drawable.whitebox);
        grid8.setImageResource(R.drawable.whitebox);
        grid9.setImageResource(R.drawable.whitebox);
    }
}