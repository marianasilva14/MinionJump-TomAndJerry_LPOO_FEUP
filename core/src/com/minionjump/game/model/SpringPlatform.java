package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.minionjump.game.view.Animation;


/**
 * Created by Sissi on 22/05/2017.
 */

public class SpringPlatform extends Platform {

    private Animation springAnimation;

    public SpringPlatform(float x, float y) {
        positionPlat = new Vector2(x, y);
        boundsPlat = new Rectangle(positionPlat.x, positionPlat.y, 150, 70);
    }

    public void update(float dt){
        collide = true;
        springAnimation.update(dt);
        if(springAnimation.isAtEnd())
            collide = false;
    }

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

    public void setAnimation(Animation ani) {
        springAnimation = ani;
    }
    public Animation getAnimation(){
        return springAnimation;
    }

}
