package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;

/**
 * Created by Sissi on 25/05/2017.
 */

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private float timeCount;
    public static Integer score;
    private Integer worldTimer;

    private Label countdownLabel;
    private static Label scoreLable;
    private Label timeLable;
    private Label minionLabel;


    public Hud(SpriteBatch sb){
        timeCount=0;
        score=0;
        worldTimer=0;
        viewport= new FitViewport(MyMinionJump.V_WIDTH, MyMinionJump.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/al-seana.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 22;
        parameter.borderWidth=1;
        parameter.borderColor=Color.BLACK;
        BitmapFont font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        scoreLable = new Label(String.format("%06d",score),new Label.LabelStyle(font12, Color.BLACK));
        timeLable= new Label("SCORE",new Label.LabelStyle(font12, Color.BLACK));
        countdownLabel= new Label(String.format("%03d",worldTimer),new Label.LabelStyle(font12, Color.BLACK));
        minionLabel = new Label("TIME",new Label.LabelStyle(font12, Color.BLACK));


        table.add(timeLable).expandX().padTop(10);
        table.add(minionLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLable).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);
    }
    public void update(float dt){
        timeCount+=dt;
        if(timeCount >= 1) {
            worldTimer++;
            countdownLabel.setText(String.format("%03d",worldTimer));
            timeCount = 0;
        }

    }
    public void dispose(){
        stage.dispose();
    }

    public static void addScore(int value){
        score+=value;
        scoreLable.setText(String.format("%06d",score));
    }


}
