package com.minionjump.game.unit_tests;

/**
 * Created by Sissi on 26/05/2017.
 */

import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.graphics.g3d.particles.influencers.SpawnInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.controller.GameController;
import com.minionjump.game.model.NormalPlatform;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.RocketPlatform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;
import com.minionjump.game.view.GameStateManager;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class unit_tests {
    @Test
    public void testIfNotLost() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        controller.update(0.1f);
        assert (controller.isLost() == false);
    }

    @Test
    public void testIfLost() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        controller.setPlatforms(new Array<Platform>());
        controller.update(10f);
        assert (controller.isLost() == true);
    }

    @Test
    public void testRandomPlatforms() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Array<Platform> um = controller.getPlatforms();

        gam = new GameStateManager();
        controller = new GameController(gam);
        Array<Platform> dois = controller.getPlatforms();

        controller.reposition(um.get(0), 0);
        boolean iguais = true;
        for (int i = 0; i < um.size; i++) {
            if (um.get(i).getClass() != dois.get(i).getClass()) {
                iguais = false;
                break;
            }
        }

        assert (iguais == false);
    }

    @Test
    public void testIfTouchedVillain() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Vector3 position = new Vector3(150, 15000, 0);
        controller.getMinion().setPosition(position);
        controller.getVillain().setPosition(position);
        controller.update(10);
        assert (controller.getVillain().collides(controller.getMinion().getBounds()) == true);
        assert (controller.getMinion().isMinionLost() == true);
    }

    @Test
    public void testIfVillainAppears() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        Vector3 position = new Vector3(150, 10050, 0);
        controller.getMinion().setPosition(position);
        assert (controller.getVillain().visible == true);
        assert (controller.villain_flag == true);
    }

    @Test
    public void testIfRespectBounds() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);

        Vector3 position = new Vector3(470, 490, 0);
        controller.getMinion().setPosition(position);

        controller.handleInputs(false, true, 0);

        assertEquals((double) controller.getMinion().getPosition().x, (double) 0);

        gam = new GameStateManager();
        controller = new GameController(gam);

        position = new Vector3(0, 490, 0);
        controller.getMinion().setPosition(position);

        controller.handleInputs(true, false, 0);

        assertEquals((double) controller.getMinion().getPosition().x, (double) 470);

    }

    @Test
    public void testVillainReposition() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);

        controller.getMinion().setPosition(new Vector3(100, 15000, 0));
        controller.update(10);
        assertTrue(controller.getVillain().visible);
    }
/*

    @Test
    public void testIfScoreRaise() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);

        boolean flag = false;
        boolean value = false, value2 = false, value3 = false, value4 = false;

        while (!value || !value2 || !value3 || !value4) {
            int pos_rand = 4;
            if (controller.getPlatforms().get(0) instanceof NormalPlatform)
                pos_rand = 0;
            else if (controller.getPlatforms().get(0) instanceof SpringPlatform)
                pos_rand = 1;
            else if (controller.getPlatforms().get(0) instanceof SplitPlatform)
                pos_rand = 2;
            else if (controller.getPlatforms().get(0) instanceof RocketPlatform)
                pos_rand = 3;

            switch (pos_rand) {
                case 0:
                    value = true;
                    break;
                case 1:
                    value2 = true;
                    break;
                case 2:
                    value3 = true;
                    break;
                case 3:
                    value4 = true;
                    break;

            }
            Rectangle bounds;
            bounds = controller.getPlatforms().get(0).getBoundsPlat();
            Vector3 position = new Vector3(bounds.x + bounds.width - 1, bounds.y + bounds.height, 0);
            controller.getMinion().setPosition(position);
            controller.update(10);
        }

        if (controller.getScore() != 0)
            flag = true;

        assert (flag == true);

        assertTrue(value);

        assertTrue(value2);

        assertTrue(value3);

        assertTrue(value4);
    }
    @Test
    public void testIfScoreRaise() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        boolean scoreRaised=false;
        float x= controller.getPlatforms().get(0).getPositionPlatform().x;
        controller.getMinion().setVelocity(new Vector3(x,-9,0));
        controller.update(10);

        if(controller.getScore() !=0)
            scoreRaised=true;

        assertTrue(scoreRaised);

    }
*/
    }
