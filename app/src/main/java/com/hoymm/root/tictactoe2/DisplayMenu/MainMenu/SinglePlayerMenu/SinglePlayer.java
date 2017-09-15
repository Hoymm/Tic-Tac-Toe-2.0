package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.MainActivity.getUniqueTag;

public class SinglePlayer extends AppCompatActivity {
    private GridFragment grid3x3, grid5x5, grid7x7;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        addGridFragments();
    }

    private void addGridFragments() {
        add3x3Grid();
        add5x5Grid();
        add7x7Grid();
    }

    private void add3x3Grid() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        grid3x3 = new GridFragment3x3();
        fragmentTransaction.replace(R.id.grid3X3ID, grid3x3, getUniqueTag(grid3x3.getClass()));
        fragmentTransaction.commit();

    }

    private void add5x5Grid() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        grid5x5 = new GridFragment5x5();
        fragmentTransaction.replace(R.id.grid5X5ID, grid5x5, getUniqueTag(grid5x5.getClass()));
        fragmentTransaction.commit();

    }

    private void add7x7Grid() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        grid7x7 = new GridFragment7x7();
        fragmentTransaction.replace(R.id.grid7X7ID, grid7x7, getUniqueTag(grid7x7.getClass()));
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void startNewClassActivityAndFinishCurrent(Class classToStart){
        Intent intent = new Intent(this, classToStart);
        startActivity(intent);
        finish();
    }
}