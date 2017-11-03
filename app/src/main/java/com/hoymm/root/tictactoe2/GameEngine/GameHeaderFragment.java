package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

import java.util.Random;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

class GameHeaderFragment extends Fragment {
    private TextView circleTV, crossTV, drawsTV, whosTurnTV;
    private int circleScores = 0, crossScores = 0, drawsScores = 0;
    protected boolean nowIsCircleTurn, youAreACircle;

    public GameHeaderFragment() {
        Log.i("TurnNow", "emptyConstructor()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("TurnNow", "onCreateView()");
        return inflater.inflate(R.layout.game_header, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initTextViews();
        drawRandomMovementOrder();
        setValuesForComponents();
        Log.i("TurnNow", "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
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

        drawWhoStartsAndWhatSymbolPlays();
        changeWhosTurnNowAlongWithDisplayingTextAndColor();
    }

    void changeWhosTurnNowAlongWithDisplayingTextAndColor() {
        whosTurnTV.setText(getWhosTurnNow());
        whosTurnTV.setTextColor(getWhosTurnTextColor());
    }

    private void drawWhoStartsAndWhatSymbolPlays() {
        int randomNumber0or1 = new Random().nextInt() % 2;
        nowIsCircleTurn =  randomNumber0or1 == 0;
        youAreACircle =  randomNumber0or1 == 0;
    }

    private int getWhosTurnTextColor() {
        if (nowIsCircleTurn)
            return ContextCompat.getColor(getContext(), R.color.circleBlue);
        return ContextCompat.getColor(getContext(), R.color.crossRed);
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

    private String getWhosTurnNow() {
        return nowIsCircleTurn ? getString(R.string.circle) : getString(R.string.cross);
    }
}
