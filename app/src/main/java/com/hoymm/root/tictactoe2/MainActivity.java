package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.MainMenu.MainMenuDisplay;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.DisplayMenuFragments;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivity extends AppCompatActivity {
    private DisplayMenuFragments displayMenuFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMenuFragments = new MainMenuDisplay(this);
    }

    @Override
    public void onBackPressed() {
        if (displayMenuFragments.isCurrentlyMainActivityFragment())
            quitApplication();
        else
            displayMenuFragments.displayMainMenu();
    }

    private void quitApplication() {
        super.onBackPressed();
    }
}
