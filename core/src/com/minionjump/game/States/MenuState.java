package com.minionjump.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 08/05/2017.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gam) {
        super(gam);
        background = new Texture("mainmenu.png");
        playBtn = new Texture("btnplay.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new PlayState(gam));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        sb.draw(playBtn, (MyMinionJump.WIDTH/4)-(playBtn.getWidth()/4), MyMinionJump.HEIGHT/3);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
