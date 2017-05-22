package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Sissi on 22/05/2017.
 */

public class SplitPlatform extends Platform {

    public SplitPlatform(float x,float y) {


        textPlat = new Texture("splitplatform.png");

        positionPlat = new Vector2(x, y);
        boundsPlat=new Rectangle(positionPlat.x, positionPlat.y, textPlat.getWidth(), textPlat.getHeight());
    }


}
