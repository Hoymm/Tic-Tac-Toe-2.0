package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu.SinglePlayerGame.SinglePlayerGame;
import com.hoymm.root.tictactoe2.GameEngine.BoardSize;
import com.hoymm.root.tictactoe2.R;

import static com.hoymm.root.tictactoe2.GameEngine.GameEngine.GAME_BOARD_MODE_KEY;

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
        Toast.makeText(getContext(), "CLICKED", Toast.LENGTH_SHORT).show();
        game3X3.putExtra(GAME_BOARD_MODE_KEY, BoardSize.board3x3);
        startActivity(game3X3);
        getActivity().finish();
    }
}
