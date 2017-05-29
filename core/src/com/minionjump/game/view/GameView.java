package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.controller.GameController;
import com.minionjump.game.model.NormalPlatform;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.RocketPlatform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;

/**
 * A view representing the game screen. Draws all the other views and
 * controls the camera.
 */
public class GameView extends State {

    /**
     * Background Texture
     */
    private Texture bg;

    /**
     * Create an hud
     */
    private Hud hud;

    /**
     * Create an viewport for the hud
     */
    private Viewport viewport;

    /**
     * Create a game controller
     */
    GameController controller;

    /**
     * Platforms textures
     */
    TextureRegion normalPlatform,splitPlatform,springPlatform,rocketPlatform;

    /**
     * Platforms animations
     */
    Animation splitAni, springAni;

    /**
     * Creates the screen
     * @param gam game state manager
     */
    public GameView(GameStateManager gam) {
        super(gam);
        controller = new GameController(gam);
        controller.getVillain().setTexture(new Texture("villain.png"));
        controller.getMinion().setTexture(new Texture("minion.png"));

        normalPlatform = new TextureRegion(new Texture("platform.png"));
        splitPlatform =  new TextureRegion(new Texture("splitplatform.png"));
        springPlatform =  new TextureRegion(new Texture("springplatform.png"));
        rocketPlatform =  new TextureRegion(new Texture("rocketplatform.png"));
        Texture textAniSpring = new Texture("springAnimation.png");
        springAni = new Animation(new TextureRegion(textAniSpring), 3, 0.25f);
        Texture textAniSplit = new Texture("splitAnimation.png");
        splitAni = new Animation(new TextureRegion(textAniSplit), 3, 0.5f);

        updateViews();

        viewport= new FitViewport(MyMinionJump.V_WIDTH, MyMinionJump.V_HEIGHT,new OrthographicCamera());
        hud= new Hud(MyMinionJump.batch);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        bg = new Texture("background.png");

    }

    /**
     * Updates platforms textures and animations
     */
    public void updateViews(){
        for(Platform plat : controller.getPlatforms()){
            if(plat instanceof NormalPlatform){
                plat.setTextureRegion(normalPlatform);
            }
            else if(plat instanceof RocketPlatform){
                plat.setTextureRegion(rocketPlatform);
            }
            else if(plat instanceof SpringPlatform){
                plat.setTextureRegion(springPlatform);
                ((SpringPlatform) plat).setAnimation(springAni);
            } else if(plat instanceof SplitPlatform){
                plat.setTextureRegion(splitPlatform);
                ((SplitPlatform) plat).setAnimation(splitAni);
            }
        }
    }


    /**
     * Handles any inputs and passes them to the controller.
     */
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

    /**
     * Update views and hud score
     * @param dt delta time
     */
    @Override
    public void update(float dt) {
        handleInput();
        controller.update(dt);
        updateViews();
        hud.update(dt);
        cam.position.y = controller.getMinion().getPosition().y + 80;
        hud.setScore(controller.getScore());

        if(controller.isLost()){
            gam.set(new GameOverMenu(gam));
        }


        cam.update();
    }

    /**
     * Renders the screen
     * @param sb sprite batch
     */
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

    /**
     * Disposes background and controller
     */
    @Override
    public void dispose() {
        bg.dispose();
        controller.dispose();
    }
}
