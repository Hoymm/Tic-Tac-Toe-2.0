package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.Settings
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayerMenu
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu.TwoPlayersMenuMenu
import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

internal class MainMenuButtonsFragment : ButtonsFragment() {

    override val listenerOfButton1: View.OnClickListener?
        get() = setOnClickListenerToStart(SinglePlayerMenu::class.java)

    override val listenerOfButton2: View.OnClickListener?
        get() = setOnClickListenerToStart(TwoPlayersMenuMenu::class.java)

    override val listenerOfButton3: View.OnClickListener?
        get() = setOnClickListenerToStart(Settings::class.java)

    override val listenerOfButton4: View.OnClickListener?
        get() = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = super.onCreateView(inflater, container, savedInstanceState)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun temporaryDisableSomeButtons() {
        buttons[3].isEnabled = false
        buttons[3].setTextColor(ContextCompat.getColor(context, R.color.buttonTextDisabled))
    }

    override fun insertButtonsTextNames() {
        insertButtonNamesFromAnArrayID(R.array.mainActivityButtonNames)
    }

    private fun setOnClickListenerToStart(classToStart: Class<*>): View.OnClickListener
            = View.OnClickListener { startNewActivityAndFinishCurrent(classToStart) }

    private fun startNewActivityAndFinishCurrent(classToStart: Class<*>) {
        val intent = Intent(activity, classToStart)
        activity.startActivity(intent)
        activity.finish()
    }
}
