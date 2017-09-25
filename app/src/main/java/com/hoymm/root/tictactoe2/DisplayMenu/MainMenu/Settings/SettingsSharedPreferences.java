package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings;

import android.content.Context;
import android.content.SharedPreferences;

import com.hoymm.root.tictactoe2.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Damian Muca - Kaizen (25.09.17)
 */

public class SettingsSharedPreferences {

    public static void saveSoundEnableState(Context context, boolean isEnabled){
        String settingsSoundKey = context.getString(R.string.SettingsSoundSP);
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(settingsSoundKey, isEnabled);
        editor.apply();
    }

    public static void saveVibrationEnableState(Context context, boolean isEnabled){
        String settingsVibrationKey = context.getString(R.string.SettingsVibrationSP);
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(settingsVibrationKey, isEnabled);
        editor.apply();
    }

    public static void saveSpeakerEnableState(Context context, boolean isEnabled){
        String settingsSpeakerKey = context.getString(R.string.SettingsSpeakerSP);
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(settingsSpeakerKey, isEnabled);
        editor.apply();
    }

    public static void saveDifficultyId(Context context, int difficultyID){
        String settingsDifficulyKey = context.getString(R.string.SettingsDifficulySP);
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(settingsDifficulyKey, difficultyID);
        editor.apply();
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        return preferences.edit();
    }

    public static int getDifficultyId(Context context){
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        String difficultyKey = context.getString(R.string.SettingsDifficulySP);
        return preferences.getInt(difficultyKey, R.id.mediumTextID);
    }

    public static boolean isSoundEnabled(Context context){
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        String soundKey = context.getString(R.string.SettingsSoundSP);
        return preferences.getBoolean(soundKey, true);
    }

    public static boolean isVibratorEnabled(Context context){
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        String vibratorKey = context.getString(R.string.SettingsVibrationSP);
        return preferences.getBoolean(vibratorKey, true);
    }

    public static boolean isSpeakerEnabled(Context context){
        SharedPreferences preferences = getSettingsSharedPreferences(context);
        String speakerKey = context.getString(R.string.SettingsSpeakerSP);
        return preferences.getBoolean(speakerKey, true);
    }

    private static SharedPreferences getSettingsSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getString(R.string.SettingsSharedPreferences), MODE_PRIVATE);
    }
}
