package com.hoymm.root.tictactoe2.DisplayMenuFragments.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public abstract class HeaderFragment extends Fragment {
    protected TextView headerText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_header_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headerText = view.findViewById(R.id.headerTextView);
        refreshHeaderText();
    }

    protected void setHeaderTextUppercase(String text){
        this.headerText.setText(text.toUpperCase());
    }

    abstract protected void refreshHeaderText();
}
