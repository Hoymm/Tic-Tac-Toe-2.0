package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu;

import android.support.v7.app.AppCompatActivity;
import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class MainMenuDisplay extends DisplayMenu {

    public MainMenuDisplay(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void initFragmentObjects(AppCompatActivity activity) {
        super.headerFrg = new MainMenuHeaderFragment();
        super.buttonsFrg = new MainMenuButtonsFragment(activity);
    }
}
