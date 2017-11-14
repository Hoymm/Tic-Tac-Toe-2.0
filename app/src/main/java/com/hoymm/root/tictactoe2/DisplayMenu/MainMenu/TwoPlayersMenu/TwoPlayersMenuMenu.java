package com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.TwoPlayersMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu;
import com.hoymm.root.tictactoe2.MainActivity;

/**
 * Created by Damian Muca - Kaizen (15.09.17)
 */

public class TwoPlayersMenuMenu extends DisplayMenu {

    @Override
    protected void initFragmentObjects(AppCompatActivity activity) {
        setHeaderFrg(new TwoPlayersHeaderFragment());
        setButtonsFrg(new TwoPlayersButtonsFragment());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
