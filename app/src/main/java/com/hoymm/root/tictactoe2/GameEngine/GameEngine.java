package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract public class GameEngine extends AppCompatActivity {
    public static final String GAME_BOARD_MODE_KEY = "com.hoymm.root.tictactoe2.GameEngine.com.hoymm.root.tictactoe2.GameEngine";

    private GameScores gameScores;
    private BoardSize boardSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        gameScores = new GameScores(this);
    }
}
