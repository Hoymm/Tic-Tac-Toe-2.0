package com.hoymm.root.tictactoe2.MainActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.ButtonsFragment;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivityButtons extends ButtonsFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonsTextNames();
    }

    private void setButtonsTextNames() {
        String [] buttonTextNames = getContext().getResources().getStringArray(R.array.mainActivityButtonNames);
        for (int i = 0; i < buttons.length; ++i)
            buttons[i].setText(buttonTextNames[i]);
    }
}
