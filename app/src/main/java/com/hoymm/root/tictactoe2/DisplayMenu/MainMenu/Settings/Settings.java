package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hoymm.root.tictactoe2.R;


public class Settings extends AppCompatActivity {
    private TextView easy, medium, hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        handleDifficultyPart();
        initEffectsSettingsFragment();
    }

    private void handleDifficultyPart() {
        initDifficulyTextViews();
        difficultyTextsSetOnClickBehavior();
        restoreDifficultyLastConfiguration();
    }

    private void initDifficulyTextViews() {
        easy = (TextView) findViewById(R.id.easyTextID);
        medium = (TextView) findViewById(R.id.mediumTextID);
        hard = (TextView) findViewById(R.id.hardTextID);
    }

    private void difficultyTextsSetOnClickBehavior() {
        easy.setOnClickListener(getClickListenerForDifficultyTextClicked());
        medium.setOnClickListener(getClickListenerForDifficultyTextClicked());
        hard.setOnClickListener(getClickListenerForDifficultyTextClicked());
    }


    @NonNull
    private View.OnClickListener getClickListenerForDifficultyTextClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Difficuly", view.getId() + ".");
                SettingsSharedPreferences.saveDifficultyId(getApplicationContext(), view.getId());
                disableAllOfTextViews();
                view.setActivated(true);
            }
        };
    }

    private void restoreDifficultyLastConfiguration() {
        disableAllOfTextViews();
        readSharedPreferencesAndEnableLast();
    }

    private void disableAllOfTextViews() {
        easy.setEnabled(false);
        medium.setEnabled(false);
        hard.setEnabled(false);
    }

    private void readSharedPreferencesAndEnableLast() {
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(getApplicationContext());
        switch (idOfDifficulyEnabled){
            case R.id.easyTextID:
                easy.setActivated(true);
                break;
            default:
            case R.id.mediumTextID:
                medium.setActivated(true);
                break;
            case R.id.hardTextID:
                hard.setActivated(true);
                break;
        }
    }

    private void initEffectsSettingsFragment() {
        EffectsFragment effectsFragment = new EffectsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.settingsEffectsID, effectsFragment);
        fragmentTransaction.commit();
    }
}
