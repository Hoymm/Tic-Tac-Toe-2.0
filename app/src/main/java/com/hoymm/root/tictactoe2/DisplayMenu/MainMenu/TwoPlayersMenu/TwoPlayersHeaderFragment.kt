package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu

import android.os.Bundle
import android.view.View

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.HeaderFragment
import com.hoymm.root.tictactoe2.R

/**
 * File created by Damian Muca - Kaizen on 07.09.17.
 */

internal class TwoPlayersHeaderFragment : HeaderFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun refreshHeaderText() {
        setHeaderTextUppercase(getString(R.string.two_players))
    }
}
