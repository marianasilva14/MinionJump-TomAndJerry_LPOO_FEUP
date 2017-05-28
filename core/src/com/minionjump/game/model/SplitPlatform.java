package com.minionjump.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.minionjump.game.view.Animation;

/**
 * Class that represents a platform of the split type
 */
public class SplitPlatform extends Platform {

    /**
     * Animation of split platform animation
     */
    private Animation splitAnimation;

    /**
     * Constructs a split platform and initialize the bounds of this type of platform
     *
     * @param x The x-coordinate of this platform.
     * @param y The y-coordinate of this platform.
     */
    public SplitPlatform(float x,float y) {
        positionPlat = new Vector2(x, y);
        boundsPlat = new Rectangle(positionPlat.x, positionPlat.y, 143, 18);
    }

    /**
     * Method that updates the animation of split platform
     * @param dt
     */
    public void update(float dt){
        collide = true;
        splitAnimation.update(dt);
    }

    /**
     * If the minion collided on the platform effects the animation
     * if it does not return the normal texture
     * @return texture of platform
     */
    public TextureRegion getTextPlatform(){
        if(collide){
            return splitAnimation.getFrame();
        }
        else {
            return super.getTextPlatform();
        }
    }

    /**
     * Sets the animation of split platform
     * @param ani
     */
    public void setAnimation(Animation ani) {
        splitAnimation = ani;
    }


}