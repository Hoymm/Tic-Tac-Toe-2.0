package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class GridFragment5x5 extends GridFragment {
    @Override
    void initXMLObjects() {
        super.gridImage.setImageResource(R.drawable.grid_5x5);
        super.gridModeTextView.setText(R.string._5x5);
    }
}
