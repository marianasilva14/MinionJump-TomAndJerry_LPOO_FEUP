package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Mariana on 08/05/2017.
 */

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        Gdx.gl.glClearColor(1, 1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        states.peek().render(sb);
    }

}
