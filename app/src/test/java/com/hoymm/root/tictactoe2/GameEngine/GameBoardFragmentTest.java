package com.hoymm.root.tictactoe2.GameEngine;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hoymm on 14.11.17.
 */
public class GameBoardFragmentTest {

    @Test (expected = ExceptionInInitializerError.class)
    public void dpToPx_whenArgumentNegative() {
        GameBoardFragment.dpToPx(-2);
    }
}