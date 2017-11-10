package com.hoymm.root.tictactoe2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoymm.root.tictactoe2.DisplayMenu.MainMenu.MainMenuDisplay;
import com.hoymm.root.tictactoe2.DisplayMenu.DisplayMenu;

/**
 * Created by Damian Muca - Kaizen (12.09.17)
 */

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startActivity(new Intent(this, MainMenuDisplay.class));
        finish();
    }

}
