package com.mywbut.demotictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    public void playButtonClicked(View view) {
        Intent intent = new Intent(this, PlayerNameActivity.class);
        startActivity(intent);
    }
}