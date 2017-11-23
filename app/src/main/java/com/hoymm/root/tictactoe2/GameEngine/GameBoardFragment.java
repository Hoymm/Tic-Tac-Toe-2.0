package com.hoymm.root.tictactoe2.GameEngine;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 03.11.17.
 */

public class GameBoardFragment extends Fragment {
    private static final int fieldMargin = dpToPx(10);
    private static final int fieldPadding = dpToPx(10);
    private BoardSize boardSize;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_board_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        boardSize = (BoardSize) getArguments().get(GameEngine.Companion.getGAME_BOARD_SIZE_KEY());
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                getView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                generateGameBoard();
            }
        });


    }

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private void generateGameBoard() {
        LinearLayout generalLinearLayout = getActivity().findViewById(R.id.game_board_fragment_id);

        int howManyFieldsInRow = getHowManyFieldsInRow();
        int boardLength = Math.min(generalLinearLayout.getWidth(), generalLinearLayout.getHeight());
        boardLength -= generalLinearLayout.getPaddingLeft()*2;

        FieldParameters fieldParameters = new FieldParameters();
        fieldParameters.fieldLength = boardLength/howManyFieldsInRow - fieldMargin;

        for (int row = 0; row < howManyFieldsInRow; ++row) {
            boolean isItBottomRow = row == howManyFieldsInRow-1;
            fieldParameters.setMarginsToZero();
            setVerticalMargins(isItBottomRow, fieldParameters);
            insertBoardRow(generalLinearLayout, howManyFieldsInRow, fieldParameters);
        }
    }

    private void setVerticalMargins(boolean isItBottomRow, FieldParameters fieldParameters) {
        fieldParameters.marginBottom = fieldMargin;
        if (isItBottomRow)
            fieldParameters.marginBottom = 0;
    }

    private class FieldParameters {
        int fieldLength;
        int marginLeft, marginTop, marginRight, marginBottom;

        void setMarginsToZero(){
            marginLeft = marginTop = marginRight = marginBottom = 0;
        }
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

    private void insertBoardRow(LinearLayout generalLinearLayout, int howManyFieldsInRow, FieldParameters fieldParameters) {
        LinearLayout rowLinearLayout = createRowLinearLayout(fieldParameters);
        generalLinearLayout.addView(rowLinearLayout);
        addGameFieldsToFillRow(rowLinearLayout, howManyFieldsInRow, fieldParameters);
    }

    private LinearLayout createRowLinearLayout(FieldParameters fieldParameters) {
        LinearLayout rowLinearLayout = new LinearLayout(getContext());
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams
                (fieldParameters.fieldLength*getHowManyFieldsInRow() + (getHowManyFieldsInRow()-1)*fieldMargin
                        , fieldParameters.fieldLength);
        rowLinearLayout.setLayoutParams(rowParams);
        rowLinearLayout.setGravity(Gravity.CENTER);
        rowLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLinearLayout.setBackgroundColor(Color.RED);
        return rowLinearLayout;
    }

    private void addGameFieldsToFillRow(LinearLayout rowLinearLayout, int howManyFieldsInRow, FieldParameters fieldParameters) {
        for (int fieldIndex = 0; fieldIndex < howManyFieldsInRow; ++fieldIndex) {
            boolean isItLastRightField = fieldIndex == howManyFieldsInRow-1;
            setHorizontalMargins(isItLastRightField, fieldParameters);
            rowLinearLayout.addView(createNewBoardField(fieldParameters));
        }
    }

    private void setHorizontalMargins(boolean isItLastField, FieldParameters fieldParameters) {
        fieldParameters.marginRight = fieldMargin;
        if (isItLastField)
            fieldParameters.marginRight = 0;
    }

    private LottieAnimationView createNewBoardField(FieldParameters fieldParameters) {
        LottieAnimationView myLottieAnimationView = new LottieAnimationView(getContext());

        LinearLayout.LayoutParams fieldParams = new LinearLayout.LayoutParams(
                fieldParameters.fieldLength, fieldParameters.fieldLength);
        fieldParams.leftMargin = fieldParameters.marginLeft;
        fieldParams.topMargin = fieldParameters.marginTop;
        fieldParams.rightMargin = fieldParameters.marginRight;
        fieldParams.bottomMargin = fieldParameters.marginBottom;

        myLottieAnimationView.setLayoutParams(fieldParams);
        myLottieAnimationView.setPadding(fieldPadding, fieldPadding, fieldPadding, fieldPadding);
        //myLottieAnimationView.setAdjustViewBounds(true);
        myLottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        myLottieAnimationView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.appBackground));


        myLottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LottieAnimationView)v).setAnimation("cross.json");
                ((LottieAnimationView)v).playAnimation();
            }
        });

        return myLottieAnimationView;
    }

    public void setCircleTurnNow() {

    }
}
