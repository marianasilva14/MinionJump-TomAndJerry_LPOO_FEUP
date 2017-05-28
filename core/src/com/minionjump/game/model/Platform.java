package com.minionjump.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * A model representing platforms of the game
 */
public abstract class Platform {
    /**
     * Did the minion collides?
     */
    public boolean collide = false;
    /**
     * Texture of platform
     */
    protected TextureRegion textPlat;
    /**
     * Position of platform
     */
    protected Vector2 positionPlat;
    /**
     * Bounds of rectangle that defines the platform
     */
    protected Rectangle boundsPlat;

    /**
     * Sets the texture of platform
     * @param text
     */
    public void setTextureRegion(TextureRegion text){
        textPlat = text;
    }

    /**
     * @return texture of platform
     */
    public TextureRegion getTextPlatform() {
        return textPlat;
    }

    /**
     * @return position of platform
     */
    public Vector2 getPositionPlatform() {
        return positionPlat;
    }

    /**
     * Checks if the man collides with the platform
     * @param player
     * @return true if collides
     */
    public boolean collides(Rectangle player) {
        return player.overlaps(boundsPlat);
    }

    /**
     * @return bounds of platform
     */
    public Rectangle getBoundsPlat(){
        return boundsPlat;
    }

    /**
     * Disposes platform
     */
    public void dispose(){

    }

}
