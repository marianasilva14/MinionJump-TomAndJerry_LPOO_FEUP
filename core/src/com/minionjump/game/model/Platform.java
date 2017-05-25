package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mariana on 10/05/2017.
 */

public abstract class Platform {
    public boolean collide = false;
    public static final int PLATFORM_HEIGHT = 40;
    protected TextureRegion textPlat;
    protected Vector2 positionPlat;
    protected Rectangle boundsPlat;


    public TextureRegion getTextPlatform() {
        return textPlat;
    }

    public Vector2 getPositionPlatform() {
        return positionPlat;
    }

    public boolean collides(Rectangle player) {

            return player.overlaps(boundsPlat);

    }

    public Rectangle getBoundsPlat(){
     return boundsPlat;
    }

    public void dispose(){

    }

}
