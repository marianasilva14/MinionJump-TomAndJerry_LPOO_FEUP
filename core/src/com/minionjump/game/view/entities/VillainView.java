package com.minionjump.game.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 05/05/2017.
 */

public class VillainView extends EntityView {

    public VillainView(MyMinionJump game){
        super(game);
    }

    public Sprite createSprite(MyMinionJump game){
        Texture texture = game.getAssetManager().get("villain.png");

        return new Sprite(texture, texture.getWidth(), texture.getHeight());
    }
}
