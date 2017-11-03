package com.hoymm.root.tictactoe2.GameEngine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.GameEngine.GameBoardFragments.Board3x3Fragment;
import com.hoymm.root.tictactoe2.GameEngine.GameBoardFragments.GameBoardFragment;
import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract public class GameEngine extends AppCompatActivity {
    public static final String GAME_BOARD_MODE_KEY = "com.hoymm.root.tictactoe2.GameEngine.com.hoymm.root.tictactoe2.GameEngine";

    protected GameHeaderFragment headerFragment;
    protected GameBoardFragment boardFragment;
    protected GameFooterFragment footerFragment;

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
        headerFragment = new GameHeaderFragment();
        addNewFragment(R.id.gameHeader, headerFragment);
    }

    private void initAndAddBoardFragment() {
        initBoardFragment();
        addNewFragment(R.id.gameBoardFragment, boardFragment);
    }

    private void initBoardFragment() {
        switch (getBoardSize()){
            default:
            case board3x3:
                boardFragment = new Board3x3Fragment();
                break;
        }
    }

    private BoardSize getBoardSize() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        return (BoardSize) bundle.get(GAME_BOARD_MODE_KEY);
    }

    private void initAndAddFooterFragment() {
        footerFragment = new GameFooterFragment();
        addNewFragment(R.id.gameFooter, footerFragment);
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
