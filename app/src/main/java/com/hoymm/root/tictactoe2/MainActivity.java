package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenuFragments.MainMenu.MainMenuDisplay;
import com.hoymm.root.tictactoe2.DisplayMenuFragments.DisplayMenuFragments;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivity extends AppCompatActivity {
    private DisplayMenuFragments menuFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragments = new MainMenuDisplay(this);
    }

    @Override
    public void onBackPressed() {
        if (menuFragments.isCurrentlyMainActivityFragment())
            quitApplication();
        else
            menuFragments = new MainMenuDisplay(this);
    }

    private void quitApplication() {
        super.onBackPressed();
    }
}
