package com.minionjump.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.minionjump.game.view.Animation;

/**
 * Class that represents a platform of the spring type
 */
public class SpringPlatform extends Platform {

    /**
     * Animation of spring platform animation
     */
    private Animation springAnimation;

    /**
     * Constructs a spring platform and initialize the bounds of this type of platform
     *
     * @param x The x-coordinate of this platform.
     * @param y The y-coordinate of this platform.
     */
    public SpringPlatform(float x, float y) {
        positionPlat = new Vector2(x, y);
        boundsPlat = new Rectangle(positionPlat.x, positionPlat.y, 150, 70);
    }

    /**
     * Method that updates the animation of split platform
     * @param dt
     */
    public void update(float dt){
        collide = true;
        if(springAnimation == null)
            return;
        springAnimation.update(dt);
        if(springAnimation.isAtEnd())
            collide = false;
    }

    /**
     * If the minion collided on the platform effects the animation
     * if it does not return the normal texture
     * @return texture of platform
     */
    public TextureRegion getTextPlatform(){
        if(collide){
            return springAnimation.getFrame();
        }
        else {
            return super.getTextPlatform();
        }
    }

    public void dispose(){
        //textPlat.dispose();
    }

    /**
     * Sets the animation of spring platform
     * @param ani
     */
    public void setAnimation(Animation ani) {
        springAnimation = ani;
    }

    /**
     * @return animation of spring platform
     */
    public Animation getAnimation(){
        return springAnimation;
    }

}