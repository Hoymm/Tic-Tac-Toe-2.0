package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hoymm on 12.09.17.
 */

public class ButtonsFragment extends Fragment {
    protected Button [] buttons;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buttons_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkButtonsWithXML(view);
    }

    private void linkButtonsWithXML(View view) {
        buttons = new Button[4];
        buttons [0] = view.findViewById(R.id.button1);
        buttons [1] = view.findViewById(R.id.button2);
        buttons [2] = view.findViewById(R.id.button3);
        buttons [3] = view.findViewById(R.id.button4);
    }
}
