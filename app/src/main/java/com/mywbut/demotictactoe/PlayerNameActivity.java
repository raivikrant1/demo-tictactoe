package com.mywbut.demotictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerNameActivity extends AppCompatActivity {

    EditText editTextPlayer1, editTextPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);

        // created an instance of those 2 edittexts
        editTextPlayer1 = findViewById(R.id.editTextTextPersonName);
        editTextPlayer2 = findViewById(R.id.editTextTextPersonName2);
    }

    public void startGameBtnClicked(View view) {

        // check if player names are present
        if(editTextPlayer1.getText().toString().isEmpty() ||
                editTextPlayer2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter player name", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }
}