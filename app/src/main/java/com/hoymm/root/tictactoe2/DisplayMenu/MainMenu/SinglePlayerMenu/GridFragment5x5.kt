package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu

import android.content.Intent

import com.hoymm.root.tictactoe2.GameEngine.EnumClasses.BoardSize
import com.hoymm.root.tictactoe2.GameEngine.GameEngine
import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

internal class GridFragment5x5 : GridFragment() {

    override fun sendBoardSizeDataInfoToGame(newGameIntent: Intent): Intent =
            newGameIntent.putExtra(GameEngine.GAME_BOARD_SIZE_KEY, BoardSize.board5x5)

    override fun initXMLObjectsAndSetText() {
        gridImage.setImageResource(R.drawable.grid_5x5)
        gridModeTextView.setText(R.string._5x5)
    }
}
