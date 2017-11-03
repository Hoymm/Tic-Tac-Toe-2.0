package com.hoymm.root.tictactoe2.GameEngine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum;
import com.hoymm.root.tictactoe2.MainActivity;
import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 01.11.17.
 */

public class GameFooterFragment extends Fragment{
    static final String HARDNESS_KEY = "com.hoymm.root.tictactoe2.GameEngine.HARDNESS_KEY";
    private Button exitButton;
    private TextView hardnessDisplayTextView;
    private String gameDifficulty;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadDataThatHasBeenSentToAFragment();
        return inflater.inflate(R.layout.game_footer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initXMLObjects();
        setProperHardnessLevelText();
        setExitButtonAction();
    }

    private void loadDataThatHasBeenSentToAFragment() {
        loadDifficultyData();
    }

    private void loadDifficultyData() {
        DifficultyEnum difficultyEnum = (DifficultyEnum) getArguments().getSerializable(HARDNESS_KEY);
        assert difficultyEnum != null;
        switch(difficultyEnum){
            case easy:
                gameDifficulty = getString(R.string.easy);
                break;
            default:
            case medium:
                gameDifficulty = getString(R.string.medium);
                break;
            case hard:
                gameDifficulty = getString(R.string.hard);
                break;
        }
    }

    private void initXMLObjects() {
        exitButton = getActivity().findViewById(R.id.exitGameButtonId);
        hardnessDisplayTextView = getActivity().findViewById(R.id.hardnessDisplayTextId);
    }

    private void setProperHardnessLevelText() {
        hardnessDisplayTextView.setText(gameDifficulty);
    }

    private void setExitButtonAction() {
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });
    }
}
