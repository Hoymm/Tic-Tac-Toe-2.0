package com.hoymm.root.tictactoe2.DisplayMenuFragments.SinglePlayerMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.hoymm.root.tictactoe2.R;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void startNewClassActivityAndFinishCurrent(Class classToStart){
        Intent intent = new Intent(this, classToStart);
        startActivity(intent);
        finish();
    }
}