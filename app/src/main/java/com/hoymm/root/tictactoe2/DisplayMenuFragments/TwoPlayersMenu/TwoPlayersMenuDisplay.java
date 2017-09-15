package com.hoymm.root.tictactoe2.DisplayMenuFragments.TwoPlayersMenu;

import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.DisplayMenuFragments;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class TwoPlayersMenuDisplay extends DisplayMenuFragments {

    public TwoPlayersMenuDisplay(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void initFragmentObjects(AppCompatActivity activity) {
        super.headerFrg = new TwoPlayersHeaderFragment();
        super.buttonsFrg = new TwoPlayersButtonsFragment(activity);
    }
}
