package com.hoymm.root.tictactoe2.GameEngine;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

public class GameScores {
    private TextView circleTV, crossTV, drawsTV;
    private int circleScores = 0, crossScores = 0, drawsScores = 0;
    private AppCompatActivity activity;

    void increaseCircleScores(){
        circleTV.setText(++circleScores);
    }

    void increaseCrossScores(){
        crossTV.setText(++crossScores);
    }

    void increaseDrawsScores(){
        drawsTV.setText(++drawsScores);
    }

    public GameScores(AppCompatActivity activity) {
        this.activity = activity;
        initTextViews();
    }

    private void initTextViews() {
        circleTV = (TextView) activity.findViewById(R.id.circleScoreAmountID);
        crossTV = (TextView) activity.findViewById(R.id.crossScoresAmountID);
        drawsTV = (TextView) activity.findViewById(R.id.drawsScoresAmountID);
    }
}
