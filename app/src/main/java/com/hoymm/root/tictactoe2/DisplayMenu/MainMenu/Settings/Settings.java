package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.content.Intent;
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

        handleDifficulyButtons();
        handleEffectsButtons();
    }

    private void handleDifficulyButtons() {
        DifficulyButtons difficulyButtons = new DifficulyButtons(this);
        difficulyButtons.restoreLastConfigurationAndSetOnclickBehavior();
    }

    private void handleEffectsButtons() {
        initEffectsSettingsFragment();
    }

    private void initEffectsSettingsFragment() {
        EffectsFragment effectsFragment = new EffectsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.settingsEffectsID, effectsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
