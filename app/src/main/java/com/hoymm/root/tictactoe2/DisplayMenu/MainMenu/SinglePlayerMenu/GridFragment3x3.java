package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.DifficultyEnum;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.Settings.SettingsSharedPreferences;
import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayerGame.SinglePlayerGame;
import com.hoymm.root.tictactoe2.GameEngine.BoardSize;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_BOARD_MODE_KEY;
import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_HARDNESS_KEY;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class GridFragment3x3 extends GridFragment {
    @Override
    void initXMLObjects() {
        gridImage.setImageResource(R.drawable.grid_3x3);
        gridModeTextView.setText(R.string._3x3);
    }

    @Override
    void onFragmentClickBehavior() {
        Intent game3X3 = new Intent(getContext(), SinglePlayerGame.class);
        game3X3 = sendDataToIntent(game3X3);
        startActivity(game3X3);
        getActivity().finish();
    }

    @Override
    Intent sendDataToIntent(Intent game3X3) {
        game3X3.putExtra(GAME_BOARD_MODE_KEY, BoardSize.board3x3);
        int idOfDifficulyEnabled = SettingsSharedPreferences.getDifficultyId(getActivity());
        game3X3.putExtra(GAME_HARDNESS_KEY, DifficultyEnum.getDifficultyFromID(idOfDifficulyEnabled));
        return game3X3;
    }
}
