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

    public GameScores(AppCompatActivity activity) {
        this.activity = activity;
        initTextViews();
        setZeroValuesForComponents();
    }

    private void initTextViews() {
        circleTV = (TextView) activity.findViewById(R.id.circleScoreAmountID);
        crossTV = (TextView) activity.findViewById(R.id.crossScoresAmountID);
        drawsTV = (TextView) activity.findViewById(R.id.drawsScoresAmountID);
    }

    private void setZeroValuesForComponents() {
        circleTV.setText("0");
        crossTV.setText("0");
        drawsTV.setText("0");
    }

    void increaseCircleScores(){
        circleTV.setText(++circleScores);
    }

    void increaseCrossScores(){
        crossTV.setText(++crossScores);
    }

    void increaseDrawsScores(){
        drawsTV.setText(++drawsScores);
    }
}
