package com.minionjump.game.unit_tests;

/**
 * Created by Sissi on 26/05/2017.
 */

import com.badlogic.gdx.utils.Array;
import com.minionjump.game.controller.GameController;
import com.minionjump.game.model.Platform;
import com.minionjump.game.view.GameStateManager;

import org.junit.Test;

public class unit_tests {
    @Test
    public void teste_criar(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        controller.update(0.5f);
        assert(controller.isLost()==false);
    }

    @Test
    public void teste_perder(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        controller.setPlatforms(new Array<Platform>());
        controller.update(10f);
        assert(controller.isLost()==true);
    }

    @Test
    public void testRandomPlatforms(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Array<Platform> um =controller.getPlatforms();

        gam = new GameStateManager();
        controller = new GameController(gam);
        Array<Platform> dois =controller.getPlatforms();
        boolean iguais = true;
        for(int i = 0; i < um.size; i++){
            if(um.get(i).getClass() != dois.get(i).getClass()){
                iguais = false;
                break;
            }
        }

        assert(iguais == false);
    }
}
