package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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
 * Class that represents the state: Options Menu
 */
public class OptionsMenu extends State {
    /**
     * Texture of background to Options Menu
     */
    private Texture menuoptions;
    /**
     * Texture of buttons "Menu", "SoundOn" and "SoundOff"
     */
    private Texture menuBtn, soundOnBtn, soundOffBtn;
    /**
     * Button for "Play", "Scores" and "Options"
     */
    private Button  menuBut, soundBut;
    /**
     * Stage of this class
     */
    private Stage stage;
    /**
     * Is the sound off?
     */
    private boolean sound = false;
    /**
     * Button Sound
     */
    private Drawable buttonDrawableSound;

    /**
     * Constructs Options Menu and defines the position of each button
     * @param gam Game State Manager
     */
    public OptionsMenu(GameStateManager gam) {
        super(gam);

        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);

        menuoptions = new Texture("optionsmenu.png");
        menuBtn = new Texture("home.png");
        soundOnBtn = new Texture("soundon.png");
        soundOffBtn = new Texture("soundoff.png");
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Drawable buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(menuBtn));
        menuBut = new ImageButton(buttonDrawableSha);
        menuBut.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/7);
        menuBut.setPosition(Gdx.graphics.getWidth()/2- 3*menuBut.getWidth()/5+menuBut.getWidth()+10,0);

        stage.addActor(menuBut);

        buttonDrawableSound = new TextureRegionDrawable(new TextureRegion(soundOffBtn));
        soundBut = new ImageButton(buttonDrawableSound);
        soundBut.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 9);
        soundBut.setPosition(Gdx.graphics.getWidth() / 2 - 5 * soundBut.getWidth() / 3, Gdx.graphics.getHeight() - 4 * soundBut.getHeight());

        stage.addActor(soundBut);

        }

        /**
        *  Method for handle input
        */
        @Override
        protected void handleInput() {

        }

    /**
     * Method that updates Options Menu
     * @param dt
     */
        @Override
        public void update(float dt) {

        }

    /**
     * Method that renders Options Menu and responsible for turning the music on and off
     * @param sb
     */
        @Override
        public void render(SpriteBatch sb) {
            Gdx.gl.glClearColor(1, 1,1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            sb.setProjectionMatrix(cam.combined);
            sb.begin();
            sb.draw(menuoptions,0,0);
            sb.end();
            stage.act();
            stage.draw();

            if(menuBut.isPressed())
                gam.set(new MainMenu(gam));

            if(soundBut.isPressed())
                if(sound) {
                    MyMinionJump.music.stop();
                    sound = false;
                    buttonDrawableSound = new TextureRegionDrawable(new TextureRegion(soundOffBtn));
                    soundBut.clear();
                    soundBut = new ImageButton(buttonDrawableSound);
                    soundBut.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 9);
                    soundBut.setPosition(Gdx.graphics.getWidth() / 2 - 5 * soundBut.getWidth() / 3, Gdx.graphics.getHeight() - 4 * soundBut.getHeight());

                    stage.addActor(soundBut);
                }
                else{
                    MyMinionJump.music.play();
                    sound = true;
                    buttonDrawableSound = new TextureRegionDrawable(new TextureRegion(soundOnBtn));
                    soundBut.clear();
                    soundBut = new ImageButton(buttonDrawableSound);
                    soundBut.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 9);
                    soundBut.setPosition(Gdx.graphics.getWidth() / 2 - 5 * soundBut.getWidth() / 3, Gdx.graphics.getHeight() - 4 *soundBut.getHeight());

                   stage.addActor(soundBut);
                }

        }

    /**
     * Disposes all buttons
     */
    @Override
        public void dispose() {
            menuBtn.dispose();
            soundOnBtn.dispose();
            soundOffBtn.dispose();
            System.out.println("Menu State Disposed");
        }
    }
