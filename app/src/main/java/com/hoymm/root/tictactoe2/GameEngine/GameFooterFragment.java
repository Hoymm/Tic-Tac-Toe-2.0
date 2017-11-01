package com.hoymm.root.tictactoe2.GameEngine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 01.11.17.
 */

public class GameFooterFragment extends Fragment{
    private Button exitButton;
    private TextView hardnessDisplayTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_footer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initXMLObjects();
        setProperHardnessLevel();
    }

    private void initXMLObjects() {
        exitButton = getActivity().findViewById(R.id.exitGameButtonId);
        hardnessDisplayTextView = getActivity().findViewById(R.id.hardnessDisplayTextId);
    }

    private void setProperHardnessLevel() {
        hardnessDisplayTextView.setText("Unknown...:)");
    }
}
