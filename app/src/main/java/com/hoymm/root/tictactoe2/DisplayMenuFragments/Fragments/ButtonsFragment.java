package com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public abstract class ButtonsFragment extends Fragment {
    protected Button [] buttons;
    private AppCompatActivity activity;

    public ButtonsFragment(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buttons_fragment, container, false);
    }

    protected void insertButtonNamesFromAnArrayID(int arrayResourcesID){
        String [] buttonTextNames = getContext().getResources().getStringArray(arrayResourcesID);
        for (int i = 0; i < buttons.length; ++i)
            buttons[i].setText(buttonTextNames[i]);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkButtonsWithXML(view);
        insertButtonsTextNames();
        setButtonsOnClickAction();
    }

    private void linkButtonsWithXML(View view) {
        buttons = new Button[4];
        buttons [0] = view.findViewById(R.id.button1);
        buttons [1] = view.findViewById(R.id.button2);
        buttons [2] = view.findViewById(R.id.button3);
        buttons [3] = view.findViewById(R.id.button4);
    }

    protected void setButtonsOnClickAction() {
        buttons[0].setOnClickListener(getListenerOfButton1());
        buttons[1].setOnClickListener(getListenerOfButton2(activity));
        buttons[2].setOnClickListener(getListenerOfButton3());
        buttons[3].setOnClickListener(getListenerOfButton4());
    }

    protected abstract void insertButtonsTextNames();
    protected abstract View.OnClickListener getListenerOfButton1();
    protected abstract View.OnClickListener getListenerOfButton2(AppCompatActivity activity);
    protected abstract View.OnClickListener getListenerOfButton3();
    protected abstract View.OnClickListener getListenerOfButton4();
}
