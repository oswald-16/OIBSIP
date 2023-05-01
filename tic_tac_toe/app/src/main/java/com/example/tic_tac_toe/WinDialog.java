package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String msg;
    private final gameActivity gameActivity1;
    public WinDialog(@NonNull Context context, String msg, gameActivity gameActivity1) {
        super(context);
        this.msg=msg;
        this.gameActivity1=gameActivity1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        final TextView msgtxt=findViewById(R.id.txtResult);

        msgtxt.setText(msg);

        final Button restart=findViewById(R.id.btnRestart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameActivity1.restart();
                dismiss();
            }
        });
    }
}
