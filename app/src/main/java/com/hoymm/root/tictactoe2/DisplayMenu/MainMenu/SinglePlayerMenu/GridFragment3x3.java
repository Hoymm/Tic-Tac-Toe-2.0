package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.SinglePlayerMenu;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class GridFragment3x3 extends GridFragment {
    @Override
    void initXMLObjects() {
        super.gridImage.setImageResource(R.drawable.grid_3x3);
        super.gridModeTextView.setText(R.string._3x3);
    }
}
