package com.hoymm.root.tictactoe2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.SinglePlayer.SinglePlayer;
import com.hoymm.root.tictactoe2.TwoPlayers.TwoPlayersButtonsFragment;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivityButtonsFragment extends ButtonsFragment {

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
        insertButtonNamesFromAnArrayID(R.array.mainActivityButtonNames);
    }

    @Override
    protected void setButtonsOnClickAction() {
        buttons[0].setOnClickListener(getSinglePlayerButtonAction());
        buttons[1].setOnClickListener(getTwoPlayersButtonAction());
    }

    @NonNull
    private View.OnClickListener getSinglePlayerButtonAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewClassActivityAndFinishCurrent(SinglePlayer.class);
            }
        };
    }

    private View.OnClickListener getTwoPlayersButtonAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTwoPlayersButtonClickListener();
            }
        };
    }

    private void getTwoPlayersButtonClickListener() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        TwoPlayersButtonsFragment twoPlayersButtonsFragment = new TwoPlayersButtonsFragment();
        fragmentTransaction.replace(R.id.mainActivityButtons, twoPlayersButtonsFragment, twoPlayersButtonsFragment.getUniqueTag());
        fragmentTransaction.commit();
    }

    private void startNewClassActivityAndFinishCurrent(Class classToStart){
        Intent intent = new Intent(getActivity(), classToStart);
        getActivity().startActivity(intent);
    }
}
