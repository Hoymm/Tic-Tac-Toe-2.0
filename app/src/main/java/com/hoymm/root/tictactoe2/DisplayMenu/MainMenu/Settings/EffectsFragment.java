package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (25.09.17)
 */

public class EffectsFragment extends Fragment {
    private CheckBox sound, vibration, voice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.effects_settings_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initCheckBoxes(view);
        restoreLastConfiguration();
        setCheckBoxesListeners();
    }

    private void initCheckBoxes(View view) {
        sound = view.findViewById(R.id.effectsSoundID);
        vibration = view.findViewById(R.id.effectsVibrationID);
        voice = view.findViewById(R.id.effectsVoiceID);
    }

    private void restoreLastConfiguration() {
        sound.setChecked(SettingsSharedPreferences.isSoundEnabled(getContext()));
        vibration.setChecked(SettingsSharedPreferences.isVibratorEnabled(getContext()));
        voice.setChecked(SettingsSharedPreferences.isSpeakerEnabled(getContext()));
    }

    private void setCheckBoxesListeners() {
        setListenerForSound();
        setListenerForVibration();
        saveListenerForSpeaker();
    }

    private void setListenerForSound() {
        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SettingsSharedPreferences.saveSoundEnableState(getContext(), b);
            }
        });
    }

    private void setListenerForVibration() {
        vibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SettingsSharedPreferences.saveVibrationEnableState(getContext(), b);
            }
        });

    }

    private void saveListenerForSpeaker() {
        voice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SettingsSharedPreferences.saveSpeakerEnableState(getContext(), b);
            }
        });

    }
}
