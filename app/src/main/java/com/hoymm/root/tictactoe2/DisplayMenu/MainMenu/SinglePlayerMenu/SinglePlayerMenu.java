package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficulyFragment;
import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

public class SinglePlayerMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        addFragments();
    }

    private void addFragments() {
        addDifficulyFragment();
        addGridsFragments();
    }

    private void addDifficulyFragment() {
        addNewFragment(R.id.singlePlayerGridDifficulyChooseID, new DifficulyFragment());
    }

    private void addGridsFragments() {
        addNewFragment(R.id.grid7X7ID, new GridFragment7x7());
        addNewFragment(R.id.grid5X5ID, new GridFragment5x5());
        addNewFragment(R.id.grid3X3ID, new GridFragment3x3());
    }

    private void addNewFragment(int ID, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(ID, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}