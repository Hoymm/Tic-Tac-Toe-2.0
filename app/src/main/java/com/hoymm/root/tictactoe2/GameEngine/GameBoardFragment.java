package com.hoymm.root.tictactoe2.GameEngine;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_BOARD_SIZE_KEY;

/**
 * Created by hoymm on 03.11.17.
 */

public class GameBoardFragment extends Fragment {
    private static final int fieldMargin = 1;
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

        int fieldLength = (boardLength/howManyFieldsInRow);

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

    private static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private void insertBoardRow(LinearLayout generalLinearLayout, int howManyFieldsInRow, int fieldLength) {
        LinearLayout rowLinearLayout = createRowLinearLayout(fieldLength+fieldMargin*2);
        generalLinearLayout.addView(rowLinearLayout);
        addGameFieldsToFillRow(howManyFieldsInRow, fieldLength, rowLinearLayout);
    }

    private LinearLayout createRowLinearLayout(int height) {
        LinearLayout rowLinearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, height);
        //Log.i("HeightToSet", height + ".");
        rowLinearLayout.setLayoutParams(rowParams);
        rowLinearLayout.setGravity(Gravity.CENTER);
        rowLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLinearLayout.setBackgroundColor(Color.RED);
        return rowLinearLayout;
    }

    private void addGameFieldsToFillRow(int howManyFieldsInRow, int fieldLength, LinearLayout rowLinearLayout) {
        for (int i = 0; i < howManyFieldsInRow; ++i)
            rowLinearLayout.addView(createNewBoardField(fieldLength));
    }

    private LottieAnimationView createNewBoardField(int fieldLength) {

        /*LottieAnimationView animationView = view.findViewById(R.id.animation_id);
        animationView.setRotation(45);
        animationView.setAnimation("strikethrough.json");
        animationView.loop(true);
        animationView.playAnimation();*/

        LottieAnimationView myLottieAnimationView = new LottieAnimationView(getContext());
        LinearLayout.LayoutParams fieldParams = new LinearLayout.LayoutParams(fieldLength, fieldLength);
        fieldParams.setMargins(fieldMargin, fieldMargin, fieldMargin, fieldMargin);

        myLottieAnimationView.setLayoutParams(fieldParams);
        myLottieAnimationView.setBackgroundColor(Color.BLUE);


        myLottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LottieAnimationView)v).setAnimation("circle.json");
                ((LottieAnimationView)v).playAnimation();
            }
        });

        return myLottieAnimationView;
    }
}
