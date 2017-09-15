package com.hoymm.root.tictactoe2.DisplayMenuFragments.TwoPlayersMenu;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (14.09.17)
 */

class TwoPlayersButtonsFragment extends ButtonsFragment {
    public TwoPlayersButtonsFragment(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void insertButtonsTextNames() {
        insertButtonNamesFromAnArrayID(R.array.twoPlayersActivityButtonNames);
    }

    @Override
    protected void setButtonsOnClickAction() {

    }


    @Override
    protected View.OnClickListener getListenerOfButton1() {
        return null;
    }


    @Override
    protected View.OnClickListener getListenerOfButton2(AppCompatActivity activity) {
        return null;
    }


    @Override
    protected View.OnClickListener getListenerOfButton3() {
        return null;
    }


    @Override
    protected View.OnClickListener getListenerOfButton4() {
        return null;
    }
}
