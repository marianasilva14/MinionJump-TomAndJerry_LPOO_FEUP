package com.minionjump.game.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 05/05/2017.
 */

abstract class EntityView {

    Sprite sprite;

    EntityView(MyMinionJump game) {
        sprite = createSprite(game);
    }

    protected abstract Sprite createSprite(MyMinionJump game);

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }



}
