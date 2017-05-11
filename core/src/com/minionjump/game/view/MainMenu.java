package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 08/05/2017.
 */

public class MainMenu extends State {
    private Texture background;
    private Texture playBtn;
    private Texture scoresBtn;
    private Texture optionsBtn;

    public MainMenu(GameStateManager gam) {
        super(gam);
        background = new Texture("mainmenu.png");
        playBtn = new Texture("btnplay.png");
        scoresBtn = new Texture("scores.png");
        optionsBtn = new Texture("options.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gam.set(new PlayState(gam));
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
        sb.draw(playBtn, (MyMinionJump.WIDTH/4)-(playBtn.getWidth()/3), MyMinionJump.HEIGHT/3);
        sb.draw(scoresBtn, (MyMinionJump.WIDTH) - (optionsBtn.getWidth()), scoresBtn.getHeight() - (scoresBtn.getHeight()-1));
        sb.draw(optionsBtn, (MyMinionJump.WIDTH/2) - (scoresBtn.getWidth()/5), (optionsBtn.getHeight()-5) - (optionsBtn.getHeight()));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        scoresBtn.dispose();
        optionsBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
