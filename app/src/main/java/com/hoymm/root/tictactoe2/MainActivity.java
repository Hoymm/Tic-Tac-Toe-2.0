package com.hoymm.root.tictactoe2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateHeaderView();
    }

    private void inflateHeaderView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HeaderFragment headerFragment = new HeaderFragment();
        fragmentTransaction.add(R.id.mainActivityHeader, headerFragment);
        fragmentTransaction.commit();
    }
}
