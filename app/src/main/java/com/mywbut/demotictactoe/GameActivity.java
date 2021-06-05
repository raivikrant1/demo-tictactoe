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
    int gameState[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    int allWinState[][] =   {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {0,4,8}, {2,4,6},
            {2,5,8}, {1,4,7}
    };

    ImageView imageViewLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = (TextView) findViewById(R.id.textViewPlayerName);
        textView.setText("O's turn");

        imageViewLine = (ImageView) findViewById(R.id.imgViewLine);
        // imageViewLine.setImageResource(R.drawable.horizontal_line);
        // imageViewLine.setVisibility(View.VISIBLE);
        // imageViewLine.animate().translationYBy(1000f);

    }

    public void homeBtnClicked(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void playerTapped(View view) {
        ImageView imgView = (ImageView) view;
        int tag = Integer.parseInt(imgView.getTag().toString());

        Toast.makeText(getApplicationContext(), "Tapped: " + tag, Toast.LENGTH_LONG).show();

        // updating the game state array
        gameState[tag] = playerTurn;

        // check if it is O's turn
        if (playerTurn == 0) {
            // set O to that cell
            imgView.setImageResource(R.drawable.img_o);
            // change the turn
            playerTurn = 1;
            // inform whose turn is next
            textView.setText("X's turn");
        } else if (playerTurn == 1) {
            imgView.setImageResource(R.drawable.img_x);
            playerTurn = 0;
            textView.setText("O's turn");
        }


        // checking if one of the win state matches with gamestate array
        for (int[] oneWinState : allWinState) {
            if (gameState[oneWinState[0]] != -1 &&
                    gameState[oneWinState[0]] == gameState[oneWinState[1]] &&
                    gameState[oneWinState[1]] == gameState[oneWinState[2]]) {

                // checking who won
                if (gameState[oneWinState[0]] == 0) {
                    // O won
                    textView.setText("Player O wins");
                } else {
                    textView.setText("Player X wins");
                }
            }
        }
    }

    public void resetGame(View view) {

        for (int i = 0; i<gameState.length; i++) {
            gameState[i] = -1;
        }

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        textView.setText("");
    }
}