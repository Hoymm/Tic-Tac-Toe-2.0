package com.hoymm.root.tictactoe2.DisplayMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.R;


/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public abstract class DisplayMenu extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    protected HeaderFragment headerFrg;
    protected ButtonsFragment buttonsFrg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        initFragmentObjects(this);
        display();
    }

    abstract protected void initFragmentObjects(AppCompatActivity activity);

    private void display() {
        inflateHeaderFragment(headerFrg);
        inflateButtonsFragment(buttonsFrg);
        fragmentTransaction.commit();
    }


    private void inflateHeaderFragment(HeaderFragment headerFragment) {
        fragmentTransaction.replace(R.id.mainActivityHeader, headerFragment);
    }

    private void inflateButtonsFragment(ButtonsFragment buttonsFragment) {
        fragmentTransaction.replace(R.id.mainActivityButtons, buttonsFragment);
    }
}
