package com.minionjump.game.unit_tests;

/**
 * Created by Sissi on 26/05/2017.
 */

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.controller.GameController;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;
import com.minionjump.game.view.GameStateManager;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class unit_tests {
    @Test
    public void testIfNotLost(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        controller.update(0.1f);
        assert(controller.isLost()==false);
    }

    @Test
    public void testIfLost(){
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

        controller.reposition(um.get(0),0);
        boolean iguais = true;
        for(int i = 0; i < um.size; i++){
            if(um.get(i).getClass() != dois.get(i).getClass()){
                iguais = false;
                break;
            }
        }

        assert(iguais == false);
    }

    @Test
    public void testIfTouchedVillain(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Vector3 position = new Vector3(150,150,0);
        controller.getMinion().setPosition(position);
        controller.getVillain().setPosition(position);
        assert(controller.getVillain().collides(controller.getMinion().getBounds()) == true);
        assert(controller.getMinion().isMinionLost() == true);
    }

    @Test
    public void testIfVillainAppears(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Vector3 position = new Vector3(150,10050,0);
        controller.getMinion().setPosition(position);
        assert(controller.getVillain().visible==true);
        assert(controller.villain_flag==true);
        }

    @Test
    public void testIfRespectBounds(){
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);

        Vector3 position = new Vector3(470,490,0);
        controller.getMinion().setPosition(position);

        controller.handleInputs(false, true,0);

        assertEquals((double)controller.getMinion().getPosition().x, (double)0);

        gam = new GameStateManager();
        controller = new GameController(gam);

        position = new Vector3(0,490,0);
        controller.getMinion().setPosition(position);

        controller.handleInputs(true, false,0);

        assertEquals((double)controller.getMinion().getPosition().x, (double)470);

    }

    }
