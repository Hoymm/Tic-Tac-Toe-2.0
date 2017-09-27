package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (27.09.17)
 */

public class DifficulyFragment extends Fragment {
    private TextView easy, medium, hard;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.difficuly_settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restoreLastConfigurationAndSetOnclickBehavior();
    }


    void restoreLastConfigurationAndSetOnclickBehavior() {
        initDifficulyTextViews();
        difficultyTextsSetOnClickBehavior();
        restoreDifficultyLastConfiguration();
    }

    private void initDifficulyTextViews() {
        easy = getActivity().findViewById(R.id.easyTextID);
        medium = getActivity().findViewById(R.id.mediumTextID);
        hard = getActivity().findViewById(R.id.hardTextID);
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
                SettingsSharedPreferences.saveDifficultyId(getActivity(), view.getId());
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
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(getActivity());
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
