package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.Villain;

/**
 * Created by Sissi on 26/05/2017.
 */

public class GameView {

    public GameView(){

    }

    public static void gameState(SpriteBatch sb, Minion minion, Villain villain, Array<Platform> plat, Texture bg){
        sb.setProjectionMatrix(State.getCam().combined);
        sb.begin();
        sb.draw(bg, 0, State.getCam().position.y - (State.getCam().viewportHeight / 2));
        sb.draw(minion.getTexture(), minion.getPosition().x, minion.getPosition().y);
        if(villain.visible==true)
            sb.draw(villain.getTexture(), villain.getPosition().x, villain.getPosition().y);
        for(Platform platform : plat) {
            sb.draw(platform.getTextPlatform(), platform.getPositionPlatform().x, platform.getPositionPlatform().y);
        }
        sb.end();
        MyMinionJump.batch.setProjectionMatrix(Hud.stage.getCamera().combined);
        Hud.stage.draw();
    }
}
