package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 01.11.17.
 */

public class GameBoardFragment extends Fragment{
    private BoardSize boardSize;

    public GameBoardFragment(BoardSize boardSize) {
        this.boardSize = boardSize;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_board, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
