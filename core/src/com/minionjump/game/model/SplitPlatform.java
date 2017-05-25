package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.minionjump.game.view.Animation;

/**
 * Created by Sissi on 22/05/2017.
 */

public class SplitPlatform extends Platform {

    private Animation splitAnimation;

    public SplitPlatform(float x,float y) {
        textPlat = new TextureRegion(new Texture("splitplatform.png"));

        Texture text = new Texture("splitAnimation.png");
        splitAnimation = new Animation(new TextureRegion(text), 3, 0.5f);
        positionPlat = new Vector2(x, y);
        boundsPlat=new Rectangle(positionPlat.x, positionPlat.y, textPlat.getRegionWidth(), textPlat.getRegionHeight());
    }

    public void update(float dt){
        collide = true;
        splitAnimation.update(dt);
    }

    public TextureRegion getTextPlatform(){
        if(collide){
            return splitAnimation.getFrame();
        }
        else {
            return super.getTextPlatform();
        }
    }




}
