package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.minionjump.game.MyMinionJump;

/**
 * Class that represents the state: Scores Menu
 */
public class ScoresMenu extends State{

    /**
     * Texture of background to Scores Menu
     */
        private Texture menuscores;
    /**
     * Texture of button "Menu"
     */
        private Texture menuBtn;
    /**
     * Button for "Menu"
     */
        private Button menuBut;
    /**
     * Stage of ths class
     */
        private Stage stage;

    private Label userScore;
    /**
     * Constructs Scores Menu and defines the position of each button
     * @param gam Game State Manager
     */
        public ScoresMenu(GameStateManager gam) {
            super(gam);

            cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);

            menuscores = new Texture("scoresmenu.png");
            menuBtn = new Texture("home.png");
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/al-seana.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = 55;
            parameter.borderWidth=1;
            parameter.borderColor=Color.BLACK;
            BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
            generator.dispose(); // don't forget to dispose to avoid memory leaks!
            userScore= new Label("",new Label.LabelStyle(font12, Color.BLACK));
            userScore.setText(String.format("%06d",MyMinionJump.prefs.getScore())+ '\n');
            userScore.setPosition(Gdx.graphics.getWidth()/6, 9*Gdx.graphics.getHeight()/16);
            stage.addActor(userScore);

            Drawable buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(menuBtn));
            menuBut = new ImageButton(buttonDrawableSha);
            menuBut.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/7);
            menuBut.setPosition(Gdx.graphics.getWidth()/2- 3*menuBut.getWidth()/5+menuBut.getWidth()+10,0);

            stage.addActor(menuBut);

        }

    /**
     *  Method for handle input
     */
        @Override
        protected void handleInput() {

        }

    /**
     * Method that updates Scores Menu
     * @param dt
     */
        @Override
        public void update(float dt) {

        }

    /**
     * Method that renders Scores Menu
     * @param sb
     */
        @Override
        public void render(SpriteBatch sb) {
            Gdx.gl.glClearColor(1, 1,1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            sb.setProjectionMatrix(cam.combined);
            sb.begin();
            sb.draw(menuscores,0,0);
            sb.end();
            stage.act();
            stage.draw();

            if(menuBut.isPressed())
                gam.set(new MainMenu(gam));
        }

    /**
     * Disposes all buttons
     */
    @Override
        public void dispose() {
            menuBtn.dispose();
            System.out.println("Menu State Disposed");
        }
}
