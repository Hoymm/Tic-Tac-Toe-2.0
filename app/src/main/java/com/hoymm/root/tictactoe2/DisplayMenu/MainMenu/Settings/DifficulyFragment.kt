package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (27.09.17)
 */

class DifficulyFragment : Fragment() {
    private var easy: TextView? = null
    private var medium: TextView? = null
    private var hard: TextView? = null


    private val clickListenerForDifficultyTextClicked: View.OnClickListener
        get() = View.OnClickListener { view ->
            SettingsSharedPreferences.saveDifficultyId(activity, view.id)
            disableAllOfTextViews()
            view.isActivated = true
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.settings_fragment_difficulty, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        restoreLastConfigurationAndSetOnclickBehavior()
    }


    internal fun restoreLastConfigurationAndSetOnclickBehavior() {
        initDifficulyTextViews()
        difficultyTextsSetOnClickBehavior()
        restoreDifficultyLastConfiguration()
    }

    private fun initDifficulyTextViews() {
        easy = activity.findViewById(R.id.easyTextID)
        medium = activity.findViewById(R.id.mediumTextID)
        hard = activity.findViewById(R.id.hardTextID)
    }

    private fun difficultyTextsSetOnClickBehavior() {
        easy!!.setOnClickListener(clickListenerForDifficultyTextClicked)
        medium!!.setOnClickListener(clickListenerForDifficultyTextClicked)
        hard!!.setOnClickListener(clickListenerForDifficultyTextClicked)
    }

    private fun restoreDifficultyLastConfiguration() {
        disableAllOfTextViews()
        readSharedPreferencesAndEnableLast()
    }

    private fun disableAllOfTextViews() {
        easy!!.isActivated = false
        medium!!.isActivated = false
        hard!!.isActivated = false
    }

    private fun readSharedPreferencesAndEnableLast() {
        val idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(activity)
        when (DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled)) {
            DifficultyEnum.easy -> easy!!.isActivated = true
            DifficultyEnum.medium -> medium!!.isActivated = true
            DifficultyEnum.hard -> hard!!.isActivated = true
        }
    }
}
