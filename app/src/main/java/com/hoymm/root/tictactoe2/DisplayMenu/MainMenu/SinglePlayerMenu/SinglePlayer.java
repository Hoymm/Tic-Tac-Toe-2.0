package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.MainActivity.getUniqueTag;

public class SinglePlayer extends AppCompatActivity {
    private GridFragment grid3x3, grid5x5, grid7x7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        grid3x3 = new GridFragment3x3();
        grid5x5 = new GridFragment5x5();
        grid7x7 = new GridFragment7x7();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.grid3x3, grid3x3, getUniqueTag(this.getClass()));
        fragmentTransaction.replace(R.id.grid5x5, grid5x5, getUniqueTag(this.getClass()));
        fragmentTransaction.replace(R.id.grid7x7, grid7x7, getUniqueTag(this.getClass()));
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