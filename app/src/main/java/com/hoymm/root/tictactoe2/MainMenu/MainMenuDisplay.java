package com.hoymm.root.tictactoe2.MainMenu;

import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.R;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.DisplayMenuFragments;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class MainMenuDisplay extends DisplayMenuFragments {

    public MainMenuDisplay(AppCompatActivity activity) {
        super(activity);
        buttonsFrg = new MainMenuButtonsFragment();
        headerFrg = new MainMenuHeaderFragment();
        displayMainMenu();
    }

    private void inflateHeaderFragment(HeaderFragment headerFragment) {
        fragmentTransaction.replace(R.id.mainActivityHeader, headerFragment, getUniqueTag(this.getClass()));
    }

    private void inflateButtonsFragment(ButtonsFragment buttonsFragment) {
        fragmentTransaction.replace(R.id.mainActivityButtons, buttonsFragment, getUniqueTag(this.getClass()));
    }

    @Override
    public void displayMainMenu() {
        inflateHeaderFragment(headerFrg);
        inflateButtonsFragment(buttonsFrg);
        fragmentTransaction.commit();
    }
}
