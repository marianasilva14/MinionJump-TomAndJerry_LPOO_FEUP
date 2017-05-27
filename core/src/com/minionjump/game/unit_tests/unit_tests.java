package com.minionjump.game.unit_tests;

/**
 * Created by Sissi on 26/05/2017.
 */

import com.minionjump.game.controller.GameController;
import com.minionjump.game.view.GameStateManager;

import org.junit.Test;

public class unit_tests {
    @Test
    public void teste_criar(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        assert(controller.isLost()==false);
    }
}
