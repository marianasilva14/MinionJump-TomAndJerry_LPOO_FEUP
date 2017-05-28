package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Class of Game State Manager
 */
public class GameStateManager {
    /**
     * Stack that contains states
     */
    private Stack<State> states;

    /**
     * Constructs Game State Manager
     */
    public GameStateManager(){
        states = new Stack<State>();
    }

    /**
     * Push a state to stack of states
     * @param state
     */
    public void push(State state){
        states.push(state);
    }

    /**
     * Pop state of stack of states
     */
    public void pop(){
        states.pop().dispose();
    }

    /**
     * Sets the state
      * @param state
     */
    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    /**
     * Updates state
     * @param dt
     */
    public void update(float dt){
        states.peek().update(dt);
    }

    /**
     * Renders state
     * @param sb SpriteBatch
     */
    public void render(SpriteBatch sb){
        Gdx.gl.glClearColor(1, 1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        states.peek().render(sb);
    }

}
