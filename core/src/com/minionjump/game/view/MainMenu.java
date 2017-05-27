package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 08/05/2017.
 */

public class MainMenu extends State {
    private Texture background;
    private Texture playBtn;
    private Texture scoresBtn;
    private Texture optionsBtn;
    private Button playBut,scoresBut,optionsBut;
    private Stage stage;
    private MyMinionJump minionJump;
    private Viewport gamePort;

    public MainMenu(GameStateManager game) {
        super(game);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        background = new Texture("MainMenu.png");
        playBtn = new Texture("btnplay.png");
        scoresBtn = new Texture("scores.png");
        optionsBtn = new Texture("options.png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);


        Drawable buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(playBtn));
        playBut = new ImageButton(buttonDrawableSha);
        playBut.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/9);
        playBut.setPosition(Gdx.graphics.getWidth()/2- 3*playBut.getWidth()/4,Gdx.graphics.getHeight()/2- playBut.getHeight());

        stage.addActor( playBut);

        buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(scoresBtn));
        scoresBut = new ImageButton(buttonDrawableSha);
        scoresBut.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/5);
        scoresBut.setPosition(Gdx.graphics.getWidth()- 3*Gdx.graphics.getWidth()/5,0);

        stage.addActor(scoresBut);

        buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(optionsBtn));
        optionsBut = new ImageButton(buttonDrawableSha);
        optionsBut.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/5);
        optionsBut.setPosition(Gdx.graphics.getWidth()/2- 3*optionsBut.getWidth()/5+scoresBut.getWidth()+10,0);

        stage.addActor(optionsBut);

    }

    @Override

    public void handleInput() {

    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0);
        sb.end();
        stage.act();
        stage.draw();

        if(playBut.isPressed())
            gam.set(new GameView(gam));

        if(scoresBut.isPressed()) {
           gam.set(new ScoresMenu(gam));
        }
        if(optionsBut.isPressed()) {
           gam.set(new OptionsMenu(gam));
        }

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
