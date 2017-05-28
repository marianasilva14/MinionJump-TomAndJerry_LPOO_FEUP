package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Mariana on 10/05/2017.
 */

public class Minion {
    private static  final int GRAVITY = -15;
    private static  final int MOVEMENT = 100;
    private Vector3 position;
    private float minHeight;

    public boolean isMinionLost() {
        return minionLost;
    }

    private boolean minionLost = false;

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector3 v) {
         velocity=v;
    }
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture minion;

    public Minion(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bounds = new Rectangle(position.x, position.y,50, 47);
        minHeight=0;
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, MOVEMENT * dt);

        if(velocity.y > 0)
            minHeight += MOVEMENT*dt;
        else{
            if(position.y < minHeight)
                minionLost = true;
        }

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);

        }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition( Vector3 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return minion;
    }

    public void setTexture(Texture min){minion = min;}

    public void jump(int number){
        velocity.y = number;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle b){
        bounds=b;
    }

    public void dispose() {
        minion.dispose();
    }
}
