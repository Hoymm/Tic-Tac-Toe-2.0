package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_BOARD_SIZE_KEY;

/**
 * Created by hoymm on 03.11.17.
 */

public class GameBoardFragment extends Fragment {
    private BoardSize boardSize;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_board_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        boardSize = (BoardSize) getArguments().get(GAME_BOARD_SIZE_KEY);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                getView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                generateGameBoard();
            }
        });


    }

    private void generateGameBoard() {
        LinearLayout generalLinearLayout = getActivity().findViewById(R.id.game_board_fragment_id);

        int boardLength = Math.min(generalLinearLayout.getWidth(), generalLinearLayout.getHeight());
        int howManyFieldsInRow = getHowManyFieldsInRow();
        int fieldLength = boardLength/howManyFieldsInRow;

        for (int row = 0; row < howManyFieldsInRow; ++row)
            insertBoardRow(generalLinearLayout, howManyFieldsInRow, fieldLength);
    }

    private int getHowManyFieldsInRow() {
        switch (boardSize){
            default:
            case board3x3:
                return 3;
            case board5x5:
                return 5;
            case board7x7:
                return 7;
        }
    }

    private void insertBoardRow(LinearLayout generalLinearLayout, int howManyFieldsInRow, int fieldLength) {
        LinearLayout rowLinearLayout = createRowLinearLayout(fieldLength);
        generalLinearLayout.addView(rowLinearLayout);
        addGameFieldsToFillRow(howManyFieldsInRow, fieldLength, rowLinearLayout);
    }

    private LinearLayout createRowLinearLayout(int height) {
        LinearLayout rowLinearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, height);
        //Log.i("HeightToSet", height + ".");
        rowLinearLayout.setLayoutParams(rowParams);
        rowLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        return rowLinearLayout;
    }

    private void addGameFieldsToFillRow(int howManyFieldsInRow, int fieldLength, LinearLayout rowLinearLayout) {
        for (int i = 0; i < howManyFieldsInRow; ++i)
            rowLinearLayout.addView(createNewBoardField(fieldLength));
    }

    private Button createNewBoardField(int sideLength) {

        /*LottieAnimationView animationView = view.findViewById(R.id.animation_id);
        animationView.setRotation(45);
        animationView.setAnimation("strikethrough.json");
        animationView.loop(true);
        animationView.playAnimation();*/

        Button myButton = new Button(getContext());
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, sideLength, 1);
        myButton.setLayoutParams(buttonParams);
        myButton.setText("COS TAM");
        return myButton;
    }
}
