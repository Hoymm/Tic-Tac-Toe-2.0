package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hoymm.root.tictactoe2.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        inflateEffectsFragment();
    }

    private void inflateEffectsFragment() {
        EffectsFragment effectsFragment = new EffectsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.settingsEffectsID, effectsFragment);
        fragmentTransaction.commit();
    }
}
