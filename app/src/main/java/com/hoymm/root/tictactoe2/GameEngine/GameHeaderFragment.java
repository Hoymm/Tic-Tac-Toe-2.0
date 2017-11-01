package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

class GameHeaderFragment extends Fragment {
    private TextView circleTV, crossTV, drawsTV;
    private int circleScores = 0, crossScores = 0, drawsScores = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_header, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTextViews();
        setZeroValuesForComponents();
    }

    private void initTextViews() {
        circleTV = getActivity().findViewById(R.id.circleScoreAmountID);
        crossTV = getActivity().findViewById(R.id.crossScoresAmountID);
        drawsTV = getActivity().findViewById(R.id.drawsScoresAmountID);
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
