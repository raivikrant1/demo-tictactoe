package com.mywbut.demotictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    int playerTurn = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = (TextView) findViewById(R.id.textViewPlayerName);
        textView.setText("O's turn");
    }

    public void homeBtnClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void playerTapped(View view) {
        ImageView imgView = (ImageView) view;
        int tag = Integer.parseInt(imgView.getTag().toString());

        Toast.makeText(getApplicationContext(), "Tapped: " + tag, Toast.LENGTH_LONG).show();


        if (playerTurn == 0) {
            imgView.setImageResource(R.drawable.img_o);
            playerTurn = 1;
            textView.setText("X's turn");
        } else if (playerTurn == 1) {
            imgView.setImageResource(R.drawable.img_x);
            playerTurn = 0;
            textView.setText("O's turn");
        }

    }
}