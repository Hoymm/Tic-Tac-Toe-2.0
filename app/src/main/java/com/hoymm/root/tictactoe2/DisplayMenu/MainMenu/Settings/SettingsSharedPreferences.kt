package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings

import android.content.Context
import android.content.SharedPreferences

import com.hoymm.root.tictactoe2.R

import android.content.Context.MODE_PRIVATE

/**
 * Created by Damian Muca - Kaizen (25.09.17)
 */

object SettingsSharedPreferences {

    fun saveSoundEnableState(context: Context, isEnabled: Boolean) {
        val settingsSoundKey = context.getString(R.string.SettingsSoundSP)
        val editor = getEditor(context)
        editor.putBoolean(settingsSoundKey, isEnabled)
        editor.apply()
    }

    fun saveVibrationEnableState(context: Context, isEnabled: Boolean) {
        val settingsVibrationKey = context.getString(R.string.SettingsVibrationSP)
        val editor = getEditor(context)
        editor.putBoolean(settingsVibrationKey, isEnabled)
        editor.apply()
    }

    fun saveSpeakerEnableState(context: Context, isEnabled: Boolean) {
        val settingsSpeakerKey = context.getString(R.string.SettingsSpeakerSP)
        val editor = getEditor(context)
        editor.putBoolean(settingsSpeakerKey, isEnabled)
        editor.apply()
    }

    fun saveDifficultyId(context: Context, difficultyID: Int) {
        val settingsDifficulyKey = context.getString(R.string.SettingsDifficulySP)
        val editor = getEditor(context)
        editor.putInt(settingsDifficulyKey, difficultyID)
        editor.apply()
    }

    private fun getEditor(context: Context): SharedPreferences.Editor {
        val preferences = context.getSettingsSharedPreferences()
        return preferences.edit()
    }

    fun getDifficultyId(context: Context): Int {
        val preferences = context.getSettingsSharedPreferences()
        val difficultyKey = context.getString(R.string.SettingsDifficulySP)
        return preferences.getInt(difficultyKey, R.id.mediumTextID)
    }

    fun isSoundEnabled(context: Context): Boolean {
        val preferences = context.getSettingsSharedPreferences()
        val soundKey = context.getString(R.string.SettingsSoundSP)
        return preferences.getBoolean(soundKey, true)
    }

    fun isVibratorEnabled(context: Context): Boolean {
        val preferences = context.getSettingsSharedPreferences()
        val vibratorKey = context.getString(R.string.SettingsVibrationSP)
        return preferences.getBoolean(vibratorKey, true)
    }

    fun isSpeakerEnabled(context: Context): Boolean {
        val preferences = context.getSettingsSharedPreferences()
        val speakerKey = context.getString(R.string.SettingsSpeakerSP)
        return preferences.getBoolean(speakerKey, true)
    }

    private fun Context.getSettingsSharedPreferences(): SharedPreferences
            = getSharedPreferences(getString(R.string.SettingsSharedPreferences), MODE_PRIVATE)
}
