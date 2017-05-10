package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Mariana on 10/05/2017.
 */

public class Minion {
    private static  final int GRAVITY = -15;
    private static  final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;

    private Texture minion;

    public Minion(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        minion = new Texture("minion.png");
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, MOVEMENT * dt);
        if(position.y < 0)
            position.y = 0;

        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return minion;
    }

    public void jump(){
        velocity.y = 250;
    }
}
