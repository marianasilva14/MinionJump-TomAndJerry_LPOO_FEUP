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
 * Created by Mariana on 22/05/2017.
 */

public class OptionsMenu extends State {

        private Texture menuoptions;
        private Texture menuBtn;
        private Button  menuBut;
        private Stage stage;

        public OptionsMenu(GameStateManager gam) {
            super(gam);

            cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);

            menuoptions = new Texture("optionsmenu.png");
            menuBtn = new Texture("home.png");
            stage = new Stage();
            Gdx.input.setInputProcessor(stage);

            Drawable buttonDrawableSha = new TextureRegionDrawable(new TextureRegion(menuBtn));
            menuBut = new ImageButton(buttonDrawableSha);
            menuBut.setSize(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/7);
            menuBut.setPosition(Gdx.graphics.getWidth()/2- 3*menuBut.getWidth()/5+menuBut.getWidth()+10,0);

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
            sb.draw(menuoptions,0,0);
            sb.end();
            stage.act();
            stage.draw();

            if(menuBut.isPressed())
                gam.set(new MainMenu(gam));

        }

        @Override
        public void dispose() {
            menuBtn.dispose();
            System.out.println("Menu State Disposed");
        }
    }
