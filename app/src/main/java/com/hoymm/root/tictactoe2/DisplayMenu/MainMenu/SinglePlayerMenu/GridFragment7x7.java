package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class GridFragment7x7 extends GridFragment {
    @Override
    void initXMLObjects() {
        super.gridImage.setImageResource(R.drawable.grid_7x7);
        super.gridModeTextView.setText(R.string._7x7);
    }
}