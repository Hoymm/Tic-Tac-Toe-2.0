package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.TwoPlayers.TwoPlayersButtonsFragment;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateHeaderFragment();
        inflateMainActivityFragment();
    }

    private void inflateHeaderFragment() {
        FragmentTransaction fragmentTransaction = getFragmentTransition();
        fragmentTransaction.replace(R.id.mainActivityHeader, new MenuHeaderFragment());
        fragmentTransaction.commit();
    }

    private FragmentTransaction getFragmentTransition() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager.beginTransaction();
    }

    private void inflateMainActivityFragment() {
        FragmentTransaction fragmentTransaction = getFragmentTransition();
        fragmentTransaction.replace(R.id.mainActivityButtons, new MainActivityButtons(), MainActivityButtons.getUniqueTag());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (isCurrentlyMainActivityFragment())
            super.onBackPressed();
        else
            inflateMainActivityFragment();
    }

    private boolean isCurrentlyMainActivityFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String mainActivityButtonsFragmentTag = TwoPlayersButtonsFragment.getUniqueTag();
        return fragmentManager.findFragmentByTag(mainActivityButtonsFragmentTag) != null;
    }
}
