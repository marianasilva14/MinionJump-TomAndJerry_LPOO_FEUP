package com.minionjump.game.controller;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.NormalPlatform;
import com.minionjump.game.model.Platform;
import com.minionjump.game.model.RocketPlatform;
import com.minionjump.game.model.SplitPlatform;
import com.minionjump.game.model.SpringPlatform;
import com.minionjump.game.model.Villain;
import com.minionjump.game.view.GameStateManager;

import java.util.Random;

/**
 * Created by Sissi on 27/05/2017.
 */

public class GameController {
    private static final int PLATFORM_SPACING = 250;
    private static final int PLATFORM_COUNT = 10;

    public boolean isLost() {
        return lost;
    }

    private boolean lost =false;

    private Minion minion;
    public Minion getMinion() {
        return minion;
    }

    public Villain getVillain() {
        return villain;
    }

    public Array<Platform> getPlatforms() {
        return platforms;
    }

    private int score = 0;
    public int getScore() {
        return score;
    }


    private Villain villain;

    private Array<Platform> platforms;
    private float ymax=0;
    private int deltaX = MyMinionJump.WIDTH/2 - 150;
    private int deltaY = MyMinionJump.HEIGHT/2 - 18;
    private boolean isSplitPlatform=false;
    private boolean villain_flag=false;

    private GameStateManager gam;

    public GameController(GameStateManager gam){
        this.gam = gam;
        minion = new Minion(150, 300,gam);
        villain = new Villain(150,300, gam);

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

    public void handleInputs(boolean leftPressed, boolean rightPressed, float accelerometerX){
        Vector3 new_position = minion.getPosition();

        if(leftPressed){
            new_position.x-=15;
            minion.setPosition(new_position);
        }
        else if(rightPressed){
            new_position.x+=15;
            minion.setPosition(new_position);
        }

        if(accelerometerX != 0){
            new_position.x-=accelerometerX/1.2f;
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

    public void update(float dt) {
        minion.update(dt);

        for(int i = 0; i < platforms.size; i++){
            Platform platform = platforms.get(i);

            if(platforms.get(i).getPositionPlatform().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
                reposition(platforms.get(i),i);

            if((platforms.get(i) instanceof NormalPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(850);
                    score += 10;
                }
            }

            else if((platforms.get(i) instanceof SpringPlatform)) {
                if(((SpringPlatform) platforms.get(i)).collide){
                    ((SpringPlatform) platforms.get(i)).update(dt);
                    if(((SpringPlatform) platforms.get(i)).getAnimation().isAtEnd())
                        minion.jump(1200);
                    score+=20;
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
                    score+=30;
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
                lost = true;
        }

        if(villain.getPosition().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
            villain.reposition(villain);
    }

    public void dispose() {
        minion.dispose();
        villain.dispose();
        for(Platform platform : platforms)
            platform.dispose();
    }
}
