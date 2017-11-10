package com.hoymm.root.tictactoe2.GameEngine;

import com.hoymm.root.tictactoe2.R;

/**
 * Created by hoymm on 10.11.17.
 */

public interface GameFragsCommunication {
    String getWhosTurnNow();
    boolean isCircleTurnNow();
    boolean isYourTurnNow();
}
