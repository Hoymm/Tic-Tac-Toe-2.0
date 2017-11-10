package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;

import com.hoymm.root.tictactoe2.GameEngine.BoardSize;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_BOARD_SIZE_KEY;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class GridFragment7x7 extends GridFragment {
    @Override
    void initXMLObjects() {
        gridImage.setImageResource(R.drawable.grid_7x7);
        gridModeTextView.setText(R.string._7x7);
    }

    @Override
    Intent sendBoardSizeDataInfoToGame(Intent newGameIntent) {
        return newGameIntent.putExtra(GAME_BOARD_SIZE_KEY, BoardSize.board7x7);
    }
}
