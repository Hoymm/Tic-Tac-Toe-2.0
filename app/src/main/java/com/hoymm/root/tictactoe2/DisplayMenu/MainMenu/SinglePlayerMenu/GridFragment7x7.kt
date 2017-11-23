package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu

import android.content.Intent

import com.hoymm.root.tictactoe2.GameEngine.BoardSize
import com.hoymm.root.tictactoe2.GameEngine.GameEngine
import com.hoymm.root.tictactoe2.R
/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

internal class GridFragment7x7 : GridFragment() {

    override fun initXMLObjectsAndSetText() {
        gridImage.setImageResource(R.drawable.grid_7x7)
        gridModeTextView.setText(R.string._7x7)
    }

    override fun sendBoardSizeDataInfoToGame(newGameIntent: Intent): Intent
            = newGameIntent.putExtra(GameEngine.GAME_BOARD_SIZE_KEY, BoardSize.board7x7)
}
