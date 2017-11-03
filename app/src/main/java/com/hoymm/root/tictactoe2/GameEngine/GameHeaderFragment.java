package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

class GameHeaderFragment extends Fragment {
    private TextView circleTV, crossTV, drawsTV, whosTurnTV;
    private int circleScores = 0, crossScores = 0, drawsScores = 0;
    private boolean nowIsCircleTurn, youAreACircle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_header, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTextViews();
        drawRandomMovementOrder();
        setValuesForComponents();
    }

    private void initTextViews() {
        circleTV = getActivity().findViewById(R.id.circleScoreAmountID);
        crossTV = getActivity().findViewById(R.id.crossScoresAmountID);
        drawsTV = getActivity().findViewById(R.id.drawsScoresAmountID);
        whosTurnTV = getActivity().findViewById(R.id.turnValueID);
    }

    private void drawRandomMovementOrder() {

    }

    private void setValuesForComponents() {
        circleTV.setText(String.valueOf(circleScores));
        crossTV.setText(String.valueOf(crossScores));
        drawsTV.setText(String.valueOf(drawsScores));
        whosTurnTV.setText("no idea...");
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