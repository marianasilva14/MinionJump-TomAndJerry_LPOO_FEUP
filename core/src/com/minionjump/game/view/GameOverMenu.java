package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Sissi on 11/05/2017.
 */

public class GameOverMenu extends State{

    private Texture menugameover;
    private Texture playAgainBtn;
    private Texture menuBtn;
    private Button playAgainBut,menuBut;
    private Stage stage;

    public GameOverMenu(GameStateManager gam) {
        super(gam);

        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);

        menugameover = new Texture("menugameover.png");
        playAgainBtn = new Texture("btnplayagain.png");
        menuBtn = new Texture("btnmenu.png");
        stage = new Stage();
       Gdx.input.setInputProcessor(stage);

        Drawable buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(playAgainBtn));
        playAgainBut = new ImageButton(buttonDrawableSha);
        playAgainBut.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/5);
        playAgainBut.setPosition(Gdx.graphics.getWidth()/2- 2*playAgainBut.getWidth()/4,Gdx.graphics.getHeight()/2- 4*playAgainBut.getHeight()/3);

        stage.addActor(playAgainBut);

        buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(menuBtn));
        menuBut = new ImageButton(buttonDrawableSha);
        menuBut.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/5);
        menuBut.setPosition(Gdx.graphics.getWidth()/2- 2*menuBut.getWidth()/4,Gdx.graphics.getHeight()/2- 7*menuBut.getHeight()/3);

        stage.addActor(menuBut);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(menugameover,0,0);
        sb.end();
        stage.act();
        stage.draw();

        if(playAgainBut.isPressed())
            gam.set(new PlayState(gam));


        if(menuBut.isPressed())
            gam.set(new MainMenu(gam));

    }

    @Override
    public void dispose() {
       menugameover.dispose();
        playAgainBtn.dispose();
        menuBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
