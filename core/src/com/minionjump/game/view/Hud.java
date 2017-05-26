package com.minionjump.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private static Integer score;
    private Integer worldTimer;

    private Label countdownLabel;
    private static Label scoreLable;
    private Label timeLable;
    private Label minionLabel;
    private Label worldLabel;

    public Hud(SpriteBatch sb){
        timeCount=0;
        score=0;
        worldTimer=0;
        viewport= new FitViewport(MyMinionJump.V_WIDTH, MyMinionJump.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        scoreLable = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        timeLable= new Label("SCORE",new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        countdownLabel= new Label(String.format("%03d",worldTimer),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        minionLabel = new Label("TIME",new Label.LabelStyle(new BitmapFont(), Color.BLACK));


        table.add(timeLable).expandX().padTop(10);
        table.add(minionLabel).expandX().padTop(10);
        table.add(worldLabel).expandX().padTop(10);
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
