package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.NormalPlatform;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.RocketPlatform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;

import java.util.Random;

/**
 * Created by Mariana on 10/05/2017.
 */

public class PlayState extends State {
    private static final int PLATFORM_SPACING = 250;
    private static final int PLATFORM_COUNT = 10;

    private Minion minion;
    private Texture bg;

    private Array<Platform> platforms;
    private float ymax=0;
    private int deltaX = MyMinionJump.WIDTH/2 - 150;
    private int deltaY = MyMinionJump.HEIGHT/2 - 18;
    private boolean isSplitPlatform=false;

    public PlayState(GameStateManager gam) {
        super(gam);
        minion = new Minion(150, 300,gam);
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
        /*
        if(Gdx.input.justTouched())
            minion.jump();
            */
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



        //new_position.x+= Gdx.input.getAccelerometerX()/10;
        //System.out.println( Gdx.input.getAccelerometerX());


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



      //plat.getBoundsPlat().setPosition(plat.getPositionPlatform().x, plat.getPositionPlatform().y);

    }

    @Override
    public void update(float dt) {
        handleInput();
        minion.update(dt);
        cam.position.y = minion.getPosition().y + 80;

        for(int i = 0; i < platforms.size; i++){
            Platform platform = platforms.get(i);

            //if(cam.position.y - (cam.viewportHeight / 2) > platform.getPositionPlatform().y + platform.getTextPlatform().getRegionHeight())
            System.out.println(" y plat" +platforms.get(i).getPositionPlatform().y);
            System.out.println (" e " +(minion.getPosition().y- MyMinionJump.HEIGHT/2));
            if(platforms.get(i).getPositionPlatform().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
                reposition(platforms.get(i),i);

            if((platforms.get(i) instanceof NormalPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(850);
                }
            }

            else if((platforms.get(i) instanceof SpringPlatform)) {
                if(((SpringPlatform) platforms.get(i)).collide){
                    ((SpringPlatform) platforms.get(i)).update(dt);
                    if(((SpringPlatform) platforms.get(i)).getAnimation().isAtEnd())
                        minion.jump(1200);
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
                }
            }

            else if((platforms.get(i) instanceof SplitPlatform)) {
                if(((SplitPlatform) platforms.get(i)).collide)
                    ((SplitPlatform) platforms.get(i)).update(dt);

                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0) {
                        ((SplitPlatform) platforms.get(i)).update(dt);
                    }
                    //platforms.removeIndex(i);
                }
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, cam.position.y - (cam.viewportHeight / 2));
        sb.draw(minion.getTexture(), minion.getPosition().x, minion.getPosition().y);
        for(Platform platform : platforms) {
            sb.draw(platform.getTextPlatform(), platform.getPositionPlatform().x, platform.getPositionPlatform().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        minion.dispose();
        for(Platform platform : platforms)
            platform.dispose();
        System.out.println("Play State Disposed");
    }
}
