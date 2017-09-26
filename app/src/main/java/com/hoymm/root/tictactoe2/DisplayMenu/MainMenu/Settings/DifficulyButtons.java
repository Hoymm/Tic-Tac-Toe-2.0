package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (26.09.17)
 */

class DifficulyButtons {
    private TextView easy, medium, hard;
    private AppCompatActivity activity;

    public DifficulyButtons(AppCompatActivity activity) {
        this.activity = activity;
    }

    void restoreLastConfigurationAndSetOnclickBehavior() {
        initDifficulyTextViews();
        difficultyTextsSetOnClickBehavior();
        restoreDifficultyLastConfiguration();
    }

    private void initDifficulyTextViews() {
        easy = (TextView) activity.findViewById(R.id.easyTextID);
        medium = (TextView) activity.findViewById(R.id.mediumTextID);
        hard = (TextView) activity.findViewById(R.id.hardTextID);
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
                SettingsSharedPreferences.saveDifficultyId(activity, view.getId());
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
        easy.setActivated(false);
        medium.setActivated(false);
        hard.setActivated(false);
    }

    private void readSharedPreferencesAndEnableLast() {
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(activity);
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
}
