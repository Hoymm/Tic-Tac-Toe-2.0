package com.hoymm.root.tictactoe2.GameEngine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences;
import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

abstract public class GameEngine extends AppCompatActivity {
    public static final String GAME_BOARD_SIZE_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_BOARD_SIZE_KEY";
    public static final String GAME_HARDNESS_KEY = "com.hoymm.root.tictactoe2.GameEngine.GAME_HARDNESS_KEY";

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
        boardFragment = new GameBoardFragment();
        boardFragment.setArguments(getIntent().getExtras());
    }

    private void initAndAddFooterFragment() {
        footerFragment = new GameFooterFragment();
        footerFragment.setArguments(dataToBeSendToFooterFragment());
        addNewFragment(R.id.gameFooter, footerFragment);
    }

    private Bundle dataToBeSendToFooterFragment() {
        Bundle bundleData = new Bundle();
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(getApplicationContext());
        DifficultyEnum difficultyEnum = DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled);
        bundleData.putSerializable(GameFooterFragment.HARDNESS_KEY, difficultyEnum);
        return bundleData;
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
