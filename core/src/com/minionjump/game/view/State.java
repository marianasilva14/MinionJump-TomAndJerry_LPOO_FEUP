package com.minionjump.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Abstract class that represents state of game
 */
public abstract class State {

    /**
     * Camera
     */
    protected static OrthographicCamera cam;
    /**
     * Mouse
     */
    protected Vector3 mouse;
    /**
     * Game
     */
    protected GameStateManager gam;

    /**
     * Constructs state
     * @param gam Game State Manager
     */
    protected State(GameStateManager gam){
        this.gam = gam;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    /**
     * Method to handle input
     */
    protected abstract void handleInput();

    /**
     * Method that updates the state
     * @param dt
     */
    public abstract void update(float dt);

    /**
     * Method that renders state
     * @param sb
     */
    public abstract void render(SpriteBatch sb);

    /**
     * Method to dispose
     */
    public abstract void dispose();

    /**
     * @return camera
     */
    public static OrthographicCamera getCam(){
        return cam;
    }
}
