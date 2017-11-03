package com.hoymm.root.tictactoe2.GameEngine.GameBoardFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 03.11.17.
 */

public class Board3x3Fragment extends GameBoardFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_board, container, false);
    }
}
