package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

abstract class GridFragment extends Fragment {
    protected TextView gridModeTextView;
    protected ImageView gridImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.choose_grid_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkXMLObjects();
        initXMLObjects();
    }

    private void linkXMLObjects(){
        gridModeTextView = getActivity().findViewById(R.id.chooseGridAmountText);
        gridImage = getActivity().findViewById(R.id.chooseGridImageView);
    }

    abstract void initXMLObjects();
    abstract void setOnClickBehavior();
}
