package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings

import com.hoymm.root.tictactoe2.R

/**
 * Created by hoymm on 03.11.17.
 */

enum class DifficultyEnum {
    easy, medium, hard;

    companion object {
        fun getDifficultyFromID(ID: Int): DifficultyEnum {
            when (ID) {
                R.id.easyTextID -> return easy
                R.id.mediumTextID -> return medium
                R.id.hardTextID -> return hard
                else -> return medium
            }
        }
    }
}
