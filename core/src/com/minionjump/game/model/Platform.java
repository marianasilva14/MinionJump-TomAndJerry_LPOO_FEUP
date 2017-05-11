package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Mariana on 10/05/2017.
 */

public class Platform {
    public static final int PLATFORM_HEIGHT = 52;

    private static final int FLUCTUATION = 130;
    private static final int PLATFORM_GAP = 40;
    private static final int LOWEST_OPENING = 200;
    private Texture splitPlatform, normalPlatform;
    private Vector2 posSplitPlatform, posNormalPlatform;
    private Rectangle boundsPlatform;
    private Random rand;

    public Platform(float y){
        splitPlatform = new Texture("splitplatform.png");
        normalPlatform = new Texture("platform.png");
        rand = new Random();

        posSplitPlatform = new Vector2(rand.nextInt(FLUCTUATION) + PLATFORM_GAP + LOWEST_OPENING, y);
        posNormalPlatform = new Vector2(rand.nextInt(FLUCTUATION) + PLATFORM_GAP, y);

        boundsPlatform = new Rectangle(posNormalPlatform.x, posNormalPlatform.y, normalPlatform.getWidth(), normalPlatform.getHeight());
    }

    public Texture getSplitPlatform() {
        return splitPlatform;
    }

    public Texture getNormalPlatform() {
        return normalPlatform;
    }

    public Vector2 getPosSplitPlatform() {
        return posSplitPlatform;
    }

    public Vector2 getPosNormalPlatform() {
        return posNormalPlatform;
    }

    public void reposition(float y){
        posNormalPlatform.set(rand.nextInt(FLUCTUATION) + PLATFORM_GAP, y);
        posSplitPlatform.set(rand.nextInt(FLUCTUATION) + PLATFORM_GAP + LOWEST_OPENING, y);

        boundsPlatform.setPosition(posNormalPlatform.x, posNormalPlatform.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsPlatform);
    }

    public void dispose(){
        normalPlatform.dispose();
        splitPlatform.dispose();
    }

}
