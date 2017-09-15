package com.hoymm.root.tictactoe2.DisplayMenuFragments.MainMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.HeaderFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * File created by Damian Muca - Kaizen on 07.09.17.
 */

public class MainMenuHeaderFragment extends HeaderFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHeaderText(getString(R.string.tic_tac_toe));
    }
}
