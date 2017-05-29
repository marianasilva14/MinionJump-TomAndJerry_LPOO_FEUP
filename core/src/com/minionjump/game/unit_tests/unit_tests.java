package com.minionjump.game.unit_tests;

import com.badlogic.gdx.math.Vector2;
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

import java.util.ArrayList;

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
        controller.setPlatforms(new ArrayList<Platform>());
        controller.update(10f);
        assert (controller.isLost() == true);
    }

    @Test
    public void testRandomPlatforms() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);
        ArrayList<Platform> um = controller.getPlatforms();

        gam = new GameStateManager();
        controller = new GameController(gam);
        ArrayList<Platform> dois = controller.getPlatforms();

        controller.reposition(um.get(0), 0);
        boolean iguais = true;
        for (int i = 0; i < um.size(); i++) {
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


    @Test(timeout = 1000)
    public void testIfScoreRaise() {
        GameStateManager gam = new GameStateManager();
        GameController controller = new GameController(gam);

        boolean differentScore=false;
        boolean plat=false,plat2=false,plat3=false, plat4=false;
        int option=2;

        while(!plat || !plat2 || !plat3 || !plat4){
            if(controller.getPlatforms().get(0) instanceof NormalPlatform)
                option=0;
            else if(controller.getPlatforms().get(0) instanceof RocketPlatform)
                option=1;
            else if(controller.getPlatforms().get(0) instanceof SpringPlatform)
                option=2;
            else if(controller.getPlatforms().get(0) instanceof SplitPlatform)
                option=3;

            switch (option){
                case 0:
                    plat=true;
                    Vector2 position = controller.getPlatforms().get(0).getPositionPlatform();
                    controller.getMinion().getBounds().setPosition(position.x, position.y);
                    controller.getMinion().setVelocity(new Vector3(30,-1,0));
                    controller.platformCollision(10,controller.getPlatforms().get(0));
                    break;
                case 1:
                    plat2=true;
                    position = controller.getPlatforms().get(0).getPositionPlatform();
                    controller.getMinion().getBounds().setPosition(position.x, position.y);
                    controller.getMinion().setVelocity(new Vector3(30,-1,0));
                    controller.platformCollision(10,controller.getPlatforms().get(0));
                    break;
                case 2:
                    plat3=true;
                    position = controller.getPlatforms().get(0).getPositionPlatform();
                    controller.getMinion().getBounds().setPosition(position.x, position.y);
                    controller.getMinion().setVelocity(new Vector3(30,-1,0));
                    controller.platformCollision(10,controller.getPlatforms().get(0));
                    break;
                case 3:
                    plat4=true;
                    position = controller.getPlatforms().get(0).getPositionPlatform();
                    controller.getMinion().getBounds().setPosition(position.x, position.y);
                    controller.getMinion().setVelocity(new Vector3(30,-1,0));
                    controller.platformCollision(10,controller.getPlatforms().get(0));
                    break;
            }
            controller.reposition(controller.getPlatforms().get(0),1);
            for(int i = 0; i < controller.getPlatforms2Remove().size(); i++)
                controller.getPlatforms().remove(controller.getPlatforms2Remove().get(i));

            for(int i = 0; i < controller.getPlatforms2Add().size(); i++)
                controller.getPlatforms().add(controller.getPlatforms2Add().get(i));

            controller.getPlatforms2Remove().clear();
            controller.getPlatforms2Add().clear();

        }

        if(controller.getScore() !=0)
            differentScore=true;

        assertTrue(differentScore);

    }

    }
