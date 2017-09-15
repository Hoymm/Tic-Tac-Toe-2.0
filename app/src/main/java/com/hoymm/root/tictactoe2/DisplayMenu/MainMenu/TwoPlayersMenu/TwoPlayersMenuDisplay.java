package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu;

import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class TwoPlayersMenuDisplay extends DisplayMenu {

    public TwoPlayersMenuDisplay(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void initFragmentObjects(AppCompatActivity activity) {
        super.headerFrg = new TwoPlayersHeaderFragment();
        super.buttonsFrg = new TwoPlayersButtonsFragment(activity);
    }
}
