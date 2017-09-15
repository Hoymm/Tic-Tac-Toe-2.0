package com.hoymm.root.tictactoe2.DisplayMenu;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.MainMenuDisplay;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.MainActivity.getUniqueTag;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public abstract class DisplayMenu {
    private FragmentTransaction fragmentTransaction;
    protected HeaderFragment headerFrg;
    protected ButtonsFragment buttonsFrg;

    public DisplayMenu(AppCompatActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        initFragmentObjects(activity);
        display();
    }

    abstract protected void initFragmentObjects(AppCompatActivity activity);

    public boolean isCurrentlyMainActivityFragment() {
        String curClassTag = getUniqueTag(this.getClass());
        String mainMenuTag = getUniqueTag(MainMenuDisplay.class);

        return curClassTag.equals(mainMenuTag);
    }

    private void display() {
        inflateHeaderFragment(headerFrg);
        inflateButtonsFragment(buttonsFrg);
        fragmentTransaction.commit();
    }


    private void inflateHeaderFragment(HeaderFragment headerFragment) {
        fragmentTransaction.replace(R.id.mainActivityHeader, headerFragment, getUniqueTag(this.getClass()));
    }

    private void inflateButtonsFragment(ButtonsFragment buttonsFragment) {
        fragmentTransaction.replace(R.id.mainActivityButtons, buttonsFragment, getUniqueTag(this.getClass()));
    }
}
