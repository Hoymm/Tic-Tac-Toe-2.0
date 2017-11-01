package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initAndAddComponentsIfActivityFreshlyStarted(savedInstanceState);
    }

    private void initAndAddComponentsIfActivityFreshlyStarted(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addDifficulyButtonsFragment();
            addEffectsButtonsFragment();
        }
    }

    private void addDifficulyButtonsFragment() {
        addNewFragment(R.id.settingsDifficulyID, new DifficulyFragment());
    }

    private void addEffectsButtonsFragment() {
        addNewFragment(R.id.settingsEffectsID, new EffectsFragment());
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
