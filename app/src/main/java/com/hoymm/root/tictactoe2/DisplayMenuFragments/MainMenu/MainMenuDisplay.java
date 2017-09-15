package com.hoymm.root.tictactoe2.DisplayMenuFragments.MainMenu;

import android.support.v7.app.AppCompatActivity;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.DisplayMenuFragments;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class MainMenuDisplay extends DisplayMenuFragments {

    public MainMenuDisplay(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void initFragmentObjects() {
        super.buttonsFrg = new MainMenuButtonsFragment();
        super.headerFrg = new MainMenuHeaderFragment();
    }
}
