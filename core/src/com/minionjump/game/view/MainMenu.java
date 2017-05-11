package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Mariana on 08/05/2017.
 */

public class MainMenu extends State{
    private Texture background;
    private Texture playBtn;
    private Texture scoresBtn;
    private Texture optionsBtn;
    private Image playButton,scoresButton, optionsButton;
    private PlayState play;
    private Stage stage;
    private MyMinionJump minionJump;
    private Viewport gamePort;

    public MainMenu(GameStateManager game) {
        super(game);
        background = new Texture("mainmenu.png");
        playBtn = new Texture("btnplay.png");
        scoresBtn = new Texture("scores.png");
        optionsBtn = new Texture("options.png");
/*
        gamePort=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gamePort.apply();
        stage = new Stage(gamePort, minionJump.batch);

        //PLAY BUTTON

        float xPlayButton = Gdx.graphics.getWidth();
        float yPlayButton = Gdx.graphics.getHeight();
        float wPlayButton = Gdx.graphics.getWidth();
        float hPlayButton= Gdx.graphics.getHeight();

        playButton=new Image(playBtn);
        playButton.setWidth(wPlayButton);
        playButton.setHeight(hPlayButton);
        playButton.setPosition(xPlayButton,yPlayButton);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(playButton);

        playButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x,float y){
              gam.set(new PlayState(gam));
            }
        });*/
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
