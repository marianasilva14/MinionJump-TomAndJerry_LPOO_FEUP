package com.minionjump.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

/**
 * Class that represents a platform of the normal type
 */
public class NormalPlatform extends Platform {

    /**
     * Constructs a normal platform and initialize the bounds of this type of platform
     *
     * @param x The x-coordinate of this platform.
     * @param y The y-coordinate of this platform.
     */
    public NormalPlatform(float x,float y) {
        positionPlat = new Vector2(x, y);
        boundsPlat = new Rectangle(positionPlat.x, positionPlat.y, 150, 18);

    }

}