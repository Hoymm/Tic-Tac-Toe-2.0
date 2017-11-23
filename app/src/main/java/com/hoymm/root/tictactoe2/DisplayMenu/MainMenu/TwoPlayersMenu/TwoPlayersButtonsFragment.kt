package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu

import android.support.v4.content.ContextCompat
import android.view.View

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment
import com.hoymm.root.tictactoe2.R

/**
 * Created by Damian Muca - Kaizen (14.09.17)
 */

internal class TwoPlayersButtonsFragment : ButtonsFragment() {

    override val listenerOfButton1: View.OnClickListener?
        get() = null


    override val listenerOfButton2: View.OnClickListener?
        get() = null


    override val listenerOfButton3: View.OnClickListener?
        get() = null


    override val listenerOfButton4: View.OnClickListener?
        get() = null

    override fun insertButtonsTextNames() {
        insertButtonNamesFromAnArrayID(R.array.twoPlayersActivityButtonNames)
    }

    override fun setButtonsOnClickAction() {

    }

    override fun temporaryDisableSomeButtons() {
        for (button in buttons) {

            button.isEnabled = false
            button.setTextColor(ContextCompat.getColor(context, R.color.buttonTextDisabled))
        }
    }
}
