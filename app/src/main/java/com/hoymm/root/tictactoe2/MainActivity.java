package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateHeaderFragment();
        inflateButtonsFragment();
    }

    private void inflateHeaderFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HeaderFragment headerFragment = new HeaderFragment();
        fragmentTransaction.add(R.id.mainActivityHeader, headerFragment);
        fragmentTransaction.commit();
    }

    private void inflateButtonsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ButtonsFragment buttonsFragment = new ButtonsFragment();
        fragmentTransaction.add(R.id.mainActivityButtons, buttonsFragment);
        fragmentTransaction.commit();
    }
}
