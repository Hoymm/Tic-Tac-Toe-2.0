package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * File created by Damian Muca - Kaizen on 07.09.17.
 */

class TwoPlayersHeaderFragment extends HeaderFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void refreshHeaderText() {
        setHeaderTextUppercase(getString(R.string.two_players));
    }
}
