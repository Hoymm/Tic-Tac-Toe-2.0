package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.MainMenuDisplay;
import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivity extends AppCompatActivity {
    public static DisplayMenu displayMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.displayMenu = new MainMenuDisplay(this);
    }

    @Override
    public void onBackPressed() {
        if (MainActivity.displayMenu.isCurrentlyMainActivityFragment())
            quitApplication();
        else
            MainActivity.displayMenu = new MainMenuDisplay(this);
    }

    private void quitApplication() {
        super.onBackPressed();
    }

    public static String getUniqueTag(Class aClass){
        return aClass.getPackage() + aClass.getName();
    }
}
