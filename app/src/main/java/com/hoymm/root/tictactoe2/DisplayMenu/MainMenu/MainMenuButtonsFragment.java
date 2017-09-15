package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoymm.root.tictactoe2.DisplayMenu.Fragments.ButtonsFragment;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayer;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu.TwoPlayersMenuDisplay;
import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

class MainMenuButtonsFragment extends ButtonsFragment {

    public MainMenuButtonsFragment(AppCompatActivity activity) {
        super(activity);
    }

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
    protected View.OnClickListener getListenerOfButton1() {
        return getSinglePlayerButtonAction();
    }

    private View.OnClickListener getSinglePlayerButtonAction() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewClassActivity(SinglePlayer.class);
            }
        };
    }

    private void startNewClassActivity(Class classToStart){
        Intent intent = new Intent(getActivity(), classToStart);
        getActivity().startActivity(intent);
    }

    @Override
    protected View.OnClickListener getListenerOfButton2(final AppCompatActivity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTwoPlayersButtonClickListener(activity);
            }
        };
    }


    private void getTwoPlayersButtonClickListener(AppCompatActivity activity) {
        MainActivity.displayMenu = new TwoPlayersMenuDisplay(activity);
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
