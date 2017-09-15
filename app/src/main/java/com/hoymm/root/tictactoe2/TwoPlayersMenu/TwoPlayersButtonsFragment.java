package com.hoymm.root.tictactoe2.TwoPlayersMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (14.09.17)
 */

public class TwoPlayersButtonsFragment extends ButtonsFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected void insertButtonsTextNames() {
        insertButtonNamesFromAnArrayID(R.array.twoPlayersActivityButtonNames);
    }

    @Override
    protected void setButtonsOnClickAction() {

    }
}
