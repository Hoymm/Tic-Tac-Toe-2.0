package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayerGame.SinglePlayerGame;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_HARDNESS_KEY;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

abstract class GridFragment extends Fragment {
    protected TextView gridModeTextView;
    protected ImageView gridImage;
    protected LinearLayout entireFragmentArea;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_choose_grid_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkXMLObjects();
        initXMLObjects();
        setOnFragmentClickBehavior();
    }

    private void linkXMLObjects(){
        gridModeTextView = getActivity().findViewById(R.id.chooseGridAmountText);
        gridImage = getActivity().findViewById(R.id.chooseGridImageView);
        entireFragmentArea = getActivity().findViewById(R.id.gridFragmentChooseLinearLayoutId);
    }

    private void setOnFragmentClickBehavior() {
        entireFragmentArea.setOnClickListener(getListenerForOnFragmentClick());
    }


    @NonNull
    private View.OnClickListener getListenerForOnFragmentClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentClickBehavior();
            }
        };
    }

    void onFragmentClickBehavior() {
        Intent newGame = new Intent(getContext(), SinglePlayerGame.class);
        newGame = sendDifficultyInfoToGame(newGame);
        newGame = sendBoardSizeDataInfoToGame(newGame);
        startActivity(newGame);
        getActivity().finish();
    }

    Intent sendDifficultyInfoToGame(Intent newGameIntent) {
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(getActivity());
        newGameIntent.putExtra(GAME_HARDNESS_KEY, DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled));
        return newGameIntent;
    }

    abstract Intent sendBoardSizeDataInfoToGame(Intent newGameIntent);
    abstract void initXMLObjects();
}
