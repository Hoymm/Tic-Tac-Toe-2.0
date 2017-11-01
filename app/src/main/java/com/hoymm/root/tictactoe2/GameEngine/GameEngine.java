package com.hoymm.root.tictactoe2.GameEngine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract public class GameEngine extends AppCompatActivity {
    public static final String GAME_BOARD_MODE_KEY = "com.hoymm.root.tictactoe2.GameEngine.com.hoymm.root.tictactoe2.GameEngine";

    private GameHeaderFragment gameHeaderFragment;
    private GameBoardFragment gameBoardFragment;
    private GameFooterFragment gameFooterFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        initAndAddFragments();
    }

    private void initAndAddFragments() {
        initAndAddHeaderFragment();
        initAndAddBoardFragment();
        initAndAddFooterFragment();
    }

    private void initAndAddHeaderFragment() {
        gameHeaderFragment = new GameHeaderFragment();
        addNewFragment(R.id.gameHeader, gameHeaderFragment);
    }

    private void initAndAddFooterFragment() {
        gameFooterFragment = new GameFooterFragment();
        addNewFragment(R.id.gameFooter, gameFooterFragment);
    }

    private void initAndAddBoardFragment() {
        gameBoardFragment = new GameBoardFragment(getBoardSize());
        addNewFragment(R.id.gameBoardFragment, gameBoardFragment);
    }

    private BoardSize getBoardSize() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        return (BoardSize) bundle.get(GAME_BOARD_MODE_KEY);
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
