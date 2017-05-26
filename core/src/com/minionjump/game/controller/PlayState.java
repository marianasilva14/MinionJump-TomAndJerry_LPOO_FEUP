package com.minionjump.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.NormalPlatform;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.RocketPlatform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;
import com.minionjump.game.model.Villain;
import com.minionjump.game.view.GameOverMenu;
import com.minionjump.game.view.GameStateManager;
import com.minionjump.game.view.GameView;
import com.minionjump.game.view.Hud;
import com.minionjump.game.view.State;

import java.util.Random;

//import sun.security.mscapi.KeyStore;

/**
 * Created by Mariana on 10/05/2017.
 */

public class PlayState extends State {
    private static final int PLATFORM_SPACING = 250;
    private static final int PLATFORM_COUNT = 10;

    private Minion minion;
    private Villain villain;
    private Texture bg;
    private Hud hud;
    private Viewport viewport;
    private Array<Platform> platforms;
    private float ymax=0;
    private int deltaX = MyMinionJump.WIDTH/2 - 150;
    private int deltaY = MyMinionJump.HEIGHT/2 - 18;
    private boolean isSplitPlatform=false;
    private boolean villain_flag=false;

    public PlayState(GameStateManager gam) {
        super(gam);
        viewport= new FitViewport(MyMinionJump.V_WIDTH, MyMinionJump.V_HEIGHT,new OrthographicCamera());
        hud= new Hud(MyMinionJump.batch);
        minion = new Minion(150, 300,gam);
        villain = new Villain(150,300, gam);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        bg = new Texture("background.png");
        Random rand = new Random();
        platforms = new Array<Platform>();
        float y;
        for(int i = 0; i < PLATFORM_COUNT/2; i++){
            for(int j = 0; j < 2; j++){
                int platformType= rand.nextInt(10);

                switch (platformType){
                    case 0:
                        y=PLATFORM_SPACING*i+rand.nextFloat()*10;
                        platforms.add(new SpringPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                        if(ymax < y)
                            ymax=y;
                        break;
                    case 1:case 6:
                        if(isSplitPlatform==false) {
                            y = PLATFORM_SPACING * i + rand.nextFloat() * 10;
                            platforms.add(new SplitPlatform(MyMinionJump.WIDTH / 2 * j + rand.nextFloat() * deltaX, y));
                            if (ymax < y)
                                ymax = y;
                            isSplitPlatform = true;
                        }
                        else{
                            y=PLATFORM_SPACING*i+rand.nextFloat()*10;
                            platforms.add(new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                            if(ymax < y)
                                ymax=y;
                            isSplitPlatform=false;
                        }
                        break;
                    case 2:
                        y=PLATFORM_SPACING*i+rand.nextFloat()*10;
                        platforms.add(new RocketPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                        if(ymax < y)
                            ymax=y;
                        break;
                    case 3: case 4:    case 5: case 7:case 8:case 9:
                        y=PLATFORM_SPACING*i+rand.nextFloat()*10;
                        platforms.add(new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                        if(ymax < y)
                            ymax=y;
                        break;
                }
            }
        }
    }

    @Override
    protected void handleInput() {

        Vector3 new_position = minion.getPosition();

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            new_position.x-=15;
            minion.setPosition(new_position);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            new_position.x+=15;
            minion.setPosition(new_position);
        }
     if(Gdx.input.getAccelerometerX() != 0){
            new_position.x-=Gdx.input.getAccelerometerX()/1.2f;
        }

      if(minion.getPosition().x > MyMinionJump.WIDTH){
          new_position.x = 0 ;
          minion.setPosition(new_position);
      }
        if(minion.getPosition().x < 0){
            new_position.x = MyMinionJump.WIDTH-10;
            minion.setPosition(new_position);
        }

    }
    public void reposition(Platform plat, int i){

        float y;
        Random rand = new Random();
        float j = plat.getPositionPlatform().x <=  MyMinionJump.WIDTH/2? 0:1;
        int platformType= rand.nextInt(10);
        y=ymax+deltaY-40f;
        if(j == 1)
            ymax=y;
            switch (platformType){
            case 0:
                SpringPlatform plat2 = (new SpringPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                platforms.removeIndex(i);
                platforms.add(plat2);
                break;
            case 1:case 6:
                if(isSplitPlatform==false) {
                    SplitPlatform plat3 = (new SplitPlatform(MyMinionJump.WIDTH / 2 * j + rand.nextFloat() * deltaX, y));
                    platforms.removeIndex(i);
                    platforms.add(plat3);
                    isSplitPlatform=true;
                }
                else{
                    NormalPlatform plat5 = (new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                    platforms.removeIndex(i);
                    platforms.add(plat5);
                    isSplitPlatform=false;
                }
                break;
            case 2:
                RocketPlatform plat4 = (new RocketPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                platforms.removeIndex(i);
                platforms.add(plat4);
                break;
            case 3: case 4:    case 5: case 7:case 8:case 9:
                    NormalPlatform plat5 = (new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y));
                    platforms.removeIndex(i);
                    platforms.add(plat5);
                    break;

        }


    }

    @Override
    public void update(float dt) {
        handleInput();
        minion.update(dt);
        hud.update(dt);
        cam.position.y = minion.getPosition().y + 80;

        for(int i = 0; i < platforms.size; i++){
            Platform platform = platforms.get(i);

            if(platforms.get(i).getPositionPlatform().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
                reposition(platforms.get(i),i);

            if((platforms.get(i) instanceof NormalPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(850);
                    Hud.addScore(10);
                }
            }

            else if((platforms.get(i) instanceof SpringPlatform)) {
                if(((SpringPlatform) platforms.get(i)).collide){
                    ((SpringPlatform) platforms.get(i)).update(dt);
                    if(((SpringPlatform) platforms.get(i)).getAnimation().isAtEnd())
                        minion.jump(1200);
                    Hud.addScore(20);
                }

                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0 || ((SpringPlatform)platforms.get(i)).collide) {
                        minion.jump(850);
                        ((SpringPlatform)platforms.get(i)).update(dt);
                    }
                }
            }

            else if((platforms.get(i) instanceof RocketPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(1800);
                    Hud.addScore(30);
                }
            }

            else if((platforms.get(i) instanceof SplitPlatform)) {
                if(((SplitPlatform) platforms.get(i)).collide)
                    ((SplitPlatform) platforms.get(i)).update(dt);

                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0) {
                        ((SplitPlatform) platforms.get(i)).update(dt);
                    }
                }
            }
        }

        System.out.println(minion.getPosition().y);
        if(villain_flag==false) {
            if (minion.getPosition().y > 10000) {
                villain_flag= true;
                Random rand = new Random();
                float x = rand.nextInt(MyMinionJump.WIDTH);
                float y = minion.getPosition().y + x;
                Vector3 position = new Vector3(x, y, 0);
                villain.setPosition(position);
                villain.visible = true;
                villain.getBounds().setPosition(x,y);
            }
        }
        if(villain_flag==true) {
            if (villain.collides(minion.getBounds()))
                gam.set(new GameOverMenu(gam));
        }
        if(villain.getPosition().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
            villain.reposition(villain);

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        Gdx.gl.glClearColor(1, 1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GameView.gameState(sb,minion,villain,platforms,bg);
    }

    @Override
    public void dispose() {
        bg.dispose();
        minion.dispose();
        villain.dispose();
        for(Platform platform : platforms)
            platform.dispose();
    }
}
