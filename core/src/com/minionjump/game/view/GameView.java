package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.controller.GameController;
import com.minionjump.game.model.Platform;


/**
 * Created by Sissi on 26/05/2017.
 */

public class GameView extends State {

    private Texture bg;
    private Hud hud;
    private Viewport viewport;
    GameController controller;

    public GameView(GameStateManager gam) {
        super(gam);
        controller = new GameController(gam);
        viewport= new FitViewport(MyMinionJump.V_WIDTH, MyMinionJump.V_HEIGHT,new OrthographicCamera());
        hud= new Hud(MyMinionJump.batch);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        bg = new Texture("background.png");

    }

    @Override
    protected void handleInput() {

        boolean left = false;
        boolean right = false;
        float accelerometerX = 0;

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            left = true;
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            right = true;
        }


        accelerometerX = Gdx.input.getAccelerometerX();

        controller.handleInputs(left,right,accelerometerX);


    }


    @Override
    public void update(float dt) {
        handleInput();
        controller.update(dt);
        hud.update(dt);
        cam.position.y = controller.getMinion().getPosition().y + 80;
        hud.setScore(controller.getScore());

        if(controller.isLost())
            gam.set(new GameOverMenu(gam));

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        sb.setProjectionMatrix(State.getCam().combined);
        sb.begin();
        sb.draw(bg, 0, State.getCam().position.y - (State.getCam().viewportHeight / 2));
        sb.draw(controller.getMinion().getTexture(), controller.getMinion().getPosition().x, controller.getMinion().getPosition().y);
        if(controller.getVillain().visible==true)
            sb.draw(controller.getVillain().getTexture(), controller.getVillain().getPosition().x, controller.getVillain().getPosition().y);
        for(Platform platform : controller.getPlatforms()) {
            sb.draw(platform.getTextPlatform(), platform.getPositionPlatform().x, platform.getPositionPlatform().y);
        }
        sb.end();
        MyMinionJump.batch.setProjectionMatrix(Hud.stage.getCamera().combined);
        Hud.stage.draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
        controller.dispose();
    }
}
