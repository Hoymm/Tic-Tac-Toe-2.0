package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

public class SinglePlayer extends AppCompatActivity {
    private GridFragment grid3x3, grid5x5, grid7x7;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        initAndAddGridFragments();
    }

    private void initAndAddGridFragments() {
        initGrids();
        addGrids();
    }

    private void initGrids() {
        grid3x3 = new GridFragment3x3();
        grid5x5 = new GridFragment5x5();
        grid7x7 = new GridFragment7x7();
    }

    private void addGrids() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.grid7X7ID, grid7x7);
        fragmentTransaction.replace(R.id.grid5X5ID, grid5x5);
        fragmentTransaction.replace(R.id.grid3X3ID, grid3x3);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}