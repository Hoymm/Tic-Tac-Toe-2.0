package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (14.09.17)
 */

class TwoPlayersButtonsFragment extends ButtonsFragment {

    @Override
    protected void insertButtonsTextNames() {
        insertButtonNamesFromAnArrayID(R.array.twoPlayersActivityButtonNames);
    }

    @Override
    protected void setButtonsOnClickAction() {

    }

    @Override
    public void temporaryDisableSomeButtons() {
        for (Button button : buttons){

            button.setEnabled(false);
            button.setTextColor(ContextCompat.getColor(getContext(), R.color.buttonTextDisabled));
        }
    }

    @Override
    protected View.OnClickListener getListenerOfButton1() {
        return null;
    }


    @Override
    protected View.OnClickListener getListenerOfButton2() {
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
