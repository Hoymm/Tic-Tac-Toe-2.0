package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 03.11.17.
 */

public enum DifficultyEnum {
    easy, medium, hard;

    public static DifficultyEnum getDifficultyFromID(int ID){
        switch (ID){
            case R.id.easyTextID:
                return easy;
            default:
            case R.id.mediumTextID:
                return medium;
            case R.id.hardTextID:
                return hard;
        }
    }
}
