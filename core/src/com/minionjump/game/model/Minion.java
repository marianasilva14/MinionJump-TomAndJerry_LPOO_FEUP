package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * A model representing minion, protagonist of the game
 */
public class Minion {
    /**
     * The number that the minion will go down, that is, its severity
     */
    private static  final int GRAVITY = -15;
    /**
     * The number that the minion will climb
     */
    private static  final int MOVEMENT = 100;
    /**
     * The position of the minion
     */
    private Vector3 position;
    /**
     * The minimum height that minion can be
     */
    private float minHeight;
    /**
     * The velocity of minion
     */
    private Vector3 velocity;
    /**
     * Bounds of rectangle that defines the minion
     */
    private Rectangle bounds;
    /**
     * The texture that represents minion
     */
    private Texture minion;
    /**
     * Did the minion lose?
     */
    private boolean minionLost = false;

    /**
     * Constructs a minion and initialize the minimum height.
     *
     * @param x The x-coordinate of this minion.
     * @param y The y-coordinate of this minion.
     */
    public Minion(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bounds = new Rectangle(position.x, position.y,50, 47);
        minHeight=0;
    }

    /**
     * Checks if the minion lost
     * @return true if minion lost, otherwise return false
     */
    public boolean isMinionLost() {
        return minionLost;
    }

    /**
     * @return velocity of the minion
     */
    public Vector3 getVelocity() {
        return velocity;
    }

    /**
     * Sets the velocity of the minion
     * @param v The velocity
     */
    public void setVelocity(Vector3 v) {
        velocity=v;
    }

    /**
     * This function is responsible for updates game. Update minion position
     * and check to see if it has lost
     * @param dt The time was passed
     */
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

    /**
     * @return position of the minion
     */
    public Vector3 getPosition() {
        return position;
    }

    /**
     * Sets the position of the minion
     * @param position The position of the minion
     */
    public void setPosition( Vector3 position) {
        this.position = position;
    }

    /**
     * @return texture of minion
     */
    public Texture getTexture() {
        return minion;
    }

    /**
     * Sets the texture that represents the minion
     * @param min The texture of minion
     */
    public void setTexture(Texture min){minion = min;}

    /**
     * Method responsible for causing minion to jump
     * @param number
     */
    public void jump(int number){
        velocity.y = number;
    }

    /**
     * @return bounds of minion
     */
    public Rectangle getBounds(){
        return bounds;
    }

    /**
     * Sets bounds of minion
     * @param b Rectangle that represents the minion
     */
    public void setBounds(Rectangle b){
        bounds=b;
    }

    /**
     * Disposes minion
     */
    public void dispose() {
        minion.dispose();
    }
}