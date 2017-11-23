package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (25.09.17)
 */

class EffectsFragment : Fragment() {
    private var sound: CheckBox? = null
    private var vibration: CheckBox? = null
    private var voice: CheckBox? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.settings_fragment_effects, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCheckBoxes(view)
        restoreLastConfiguration()
        setCheckBoxesListeners()
    }

    private fun initCheckBoxes(view: View?) {
        sound = view!!.findViewById(R.id.effectsSoundID)
        vibration = view.findViewById(R.id.effectsVibrationID)
        voice = view.findViewById(R.id.effectsVoiceID)
    }

    private fun restoreLastConfiguration() {
        sound!!.isChecked = SettingsSharedPreferences.isSoundEnabled(context)
        vibration!!.isChecked = SettingsSharedPreferences.isVibratorEnabled(context)
        voice!!.isChecked = SettingsSharedPreferences.isSpeakerEnabled(context)
    }

    private fun setCheckBoxesListeners() {
        setListenerForSound()
        setListenerForVibration()
        saveListenerForSpeaker()
    }

    private fun setListenerForSound() {
        sound!!.setOnCheckedChangeListener { compoundButton, b -> SettingsSharedPreferences.saveSoundEnableState(context, b) }
    }

    private fun setListenerForVibration() {
        vibration!!.setOnCheckedChangeListener { compoundButton, b -> SettingsSharedPreferences.saveVibrationEnableState(context, b) }

    }

    private fun saveListenerForSpeaker() {
        voice!!.setOnCheckedChangeListener { compoundButton, b -> SettingsSharedPreferences.saveSpeakerEnableState(context, b) }

    }
}
