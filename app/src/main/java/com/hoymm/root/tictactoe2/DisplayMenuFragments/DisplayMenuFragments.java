package com.hoymm.root.tictactoe2.DisplayMenuFragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.MainMenu.MainMenuDisplay;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public abstract class DisplayMenuFragments {
    protected FragmentTransaction fragmentTransaction;
    protected HeaderFragment headerFrg;
    protected ButtonsFragment buttonsFrg;

    public DisplayMenuFragments(AppCompatActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public boolean isCurrentlyMainActivityFragment() {
        String curClassTag = getUniqueTag(this.getClass());
        String mainMenuTag = getUniqueTag(MainMenuDisplay.class);

        return curClassTag.equals(mainMenuTag);
    }

    public static String getUniqueTag(Class aClass){
        return aClass.getPackage() + aClass.getName();
    }

    public abstract void displayMainMenu();
}
