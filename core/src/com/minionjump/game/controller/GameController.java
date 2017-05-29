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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Controls the physics aspect of the game.
 */
public class GameController {
    /**
     * space between platforms
     */
    private static final int PLATFORM_SPACING = 250;

    /**
     * number of platfoms
     */
    private static final int PLATFORM_COUNT = 10;

    /**
     * Variable used to determine if the user has lost
     */
    private boolean lost =false;
    public boolean isLost() {
        return lost;
    }

    /**
     * Create the minion
     */
    private Minion minion;

    /**
     * Get Minion
     * @return minion
     */
    public Minion getMinion() {
        return minion;
    }

    /**
     * Create the villain
     */
    private Villain villain;

    /**
     * Get Villain
     * @return villain
     */
    public Villain getVillain() {
        return villain;
    }

    /**
     * Create the platforms
     */
    private ArrayList<Platform> platforms;

    /**
     * Get's platforms
     * @return platforms
     */
    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    /**
     * Create the score
     */
    private int score = 0;

    /**
     * Get's score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set's platforms
     * @param plats
     */
    public void setPlatforms(ArrayList<Platform>  plats){
        platforms = plats;
    }

    /**
     * The maximum y of platforms
     */
    private float ymax=0;

    /**
     * Variation of the positions in x of the platform
     */
    private int deltaX = MyMinionJump.WIDTH/2 - 150;

    /**
     * Variation of the positions in y of the platform
     */
    private int deltaY = MyMinionJump.HEIGHT/2 - 18;

    /**
     * Variable used to put the platforms at different heights
     */
    private int deltaYY = 100;

    /**
     * Boolean variable used to ensure that there aren't two split platforms on the same line
     */
    private boolean isSplitPlatform=false;

    /**
     * Boolean variable used to know if the village already appeared the first time
     */
    public boolean villain_flag=false;

    /**
     * Platforms to remove after platforms reposition
     */
    private ArrayList<Platform> platforms2Remove = new ArrayList<Platform>();
    /**
     * Platforms to add after platforms reposition
     */
    private ArrayList<Platform> platforms2Add = new ArrayList<Platform>();

    /**
     * Get's platforms to remove after platforms reposition
     * @return platforms2Remove
     */
    public ArrayList<Platform> getPlatforms2Remove() {
        return platforms2Remove;
    }

    /**
     * Get's platforms to add after platforms reposition
     * @return platforms2Add
     */
    public ArrayList<Platform> getPlatforms2Add() {
        return platforms2Add;
    }

    /**
     * Variable used to toggle between left and right platforms
     */
    private boolean toggle = false;

    /**
     * Game State Manager
     */
    private GameStateManager gam;

    /**
     * Constructs a minion game
     * Initializes minion,villain and platforms in their respective positions
     * @param gam game state manager
     */
    public GameController(GameStateManager gam){
        this.gam = gam;
        minion = new Minion(150, 300);
        villain = new Villain(150,300);

        Random rand = new Random();
        platforms = new ArrayList<Platform>();
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

    /**
     * Handles any inputs
     * @param leftPressed verify if the left button was pressed
     * @param rightPressed verify if the right button was pressed
     * @param accelerometerX value of accelerometer of x
     */
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

    /**
     * Resets a platform in randomly generated positions
     * @param plat platform
     * @param i position of the platform in vector
     */
    public void reposition(Platform plat, int i){

        float y;
        Random rand = new Random();
        int j;
        y=ymax+deltaY;
        if(!toggle){
            j = 0;
            toggle = true;
        }
        else {
            j=1;
            toggle = false;
        }

        int platformType= rand.nextInt(10);

        if(j == 1)
            ymax=y;
        switch (platformType){
            case 0:
                SpringPlatform plat2 = (new SpringPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y+rand.nextFloat()*deltaYY));
                platforms2Remove.add(plat);
                platforms2Add.add(plat2);
                break;
            case 1:case 6:
                if(isSplitPlatform==false) {
                    SplitPlatform plat3 = (new SplitPlatform(MyMinionJump.WIDTH / 2 * j + rand.nextFloat() * deltaX, y+rand.nextFloat()*deltaYY));
                    platforms2Remove.add(plat);
                    platforms2Add.add(plat3);
                    isSplitPlatform=true;
                }
                else{
                    NormalPlatform plat5 = (new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y+rand.nextFloat()*deltaYY));
                    platforms2Remove.add(plat);
                    platforms2Add.add(plat5);
                    isSplitPlatform=false;
                }
                break;
            case 2:
                RocketPlatform plat4 = (new RocketPlatform(MyMinionJump.WIDTH/2f*j+rand.nextFloat()*deltaX,y+rand.nextFloat()*deltaYY));
                platforms2Remove.add(plat);
                platforms2Add.add(plat4);
                break;
            case 3: case 4:    case 5: case 7:case 8:case 9:
                NormalPlatform plat5 = (new NormalPlatform(MyMinionJump.WIDTH/2*j+rand.nextFloat()*deltaX,y+rand.nextFloat()*deltaYY));
                platforms2Remove.add(plat);
                platforms2Add.add(plat5);
                break;

        }


    }

    /**
     * Makes the platform collide with the minion and updates the score
     * @param dt
     * @param platform
     */
    public void platformCollision(float dt,Platform platform) {

            if ((platform instanceof NormalPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(950);
                    score += 10;
                }
            } else if ((platform instanceof SpringPlatform)) {
                if (((SpringPlatform) platform).collide) {
                    ((SpringPlatform) platform).update(dt);
                    if (((SpringPlatform) platform).getAnimation().isAtEnd())
                        minion.jump(1200);
                    score += 20;
                }

                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0 || ((SpringPlatform) platform).collide) {
                        minion.jump(950);
                        ((SpringPlatform) platform).update(dt);
                    }
                }
            } else if ((platform instanceof RocketPlatform)) {
                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0)
                        minion.jump(1800);
                    score += 30;
                }
            } else if ((platform instanceof SplitPlatform)) {
                if (((SplitPlatform) platform).collide)
                    ((SplitPlatform) platform).update(dt);

                if (platform.collides(minion.getBounds())) {
                    if (minion.getVelocity().y < 0) {
                        ((SplitPlatform) platform).update(dt);
                    }
                }
            }
    }
    /**
     * Updates the game
     * Restores the platforms, updates the score, puts or not the minion to jump and restores and creates the villain
     * @param dt delta time
     */
    public void update(float dt) {
        minion.update(dt);

        platforms2Remove.clear();
        platforms2Add.clear();
        for(int i = 0; i < platforms.size(); i++){
            Platform platform = platforms.get(i);

            if(platforms.get(i).getPositionPlatform().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
                reposition(platforms.get(i),i);

            platformCollision(dt,platform);

        }

        for(int i = 0; i < platforms2Remove.size(); i++)
            platforms.remove(platforms2Remove.get(i));

        for(int i = 0; i < platforms2Add.size(); i++)
            platforms.add(platforms2Add.get(i));


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

        if(minion.isMinionLost())
            lost = true;

        if(villain.getPosition().y < (minion.getPosition().y- MyMinionJump.HEIGHT/2))
            villain.reposition(villain);


    }

    /**
     * Disposes of all assets.
     */
    public void dispose() {
        minion.dispose();
        villain.dispose();
        for(Platform platform : platforms)
            platform.dispose();
    }
}
