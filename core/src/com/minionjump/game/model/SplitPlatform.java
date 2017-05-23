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
        textPlat = new Texture("splitplatform.png");

        positionPlat = new Vector2(x, y);
        boundsPlat=new Rectangle(positionPlat.x, positionPlat.y, textPlat.getWidth(), textPlat.getHeight());
    }

    public void update(float dt){

        textPlat = new Texture("splitAnimation.png");
        splitAnimation = new Animation(new TextureRegion(textPlat), 3, 0.5f);
        splitAnimation.update(dt);
    }

    public TextureRegion getTexture(){
        return splitAnimation.getFrame();
    }


}
