package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.minionjump.game.MyMinionJump;

import java.util.Random;

/**
 * A model representing villain
 */
public class Villain{
    /**
     * Position of villain
     */
    private Vector3 position;
    /**
     * Minimum height of villain appears
     */
    private float minHeight;
    /**
     * Velocity of villain
     */
    private Vector3 velocity;
    /**
     * Bounds of rectangle that defines the villain
     */
    private Rectangle bounds;
    /**
     * Texture that represents the villain
     */
    private Texture villain;
    /**
     * Is the villain visible?
     */
    public boolean visible;

    /**
     * Constructs a villain and initialize the minimum height and his visibility
     *
     * @param x The x-coordinate of the villain.
     * @param y The y-coordinate of the villain
     */
    public Villain(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);

        minHeight=0;
        visible=false;
        bounds = new Rectangle(position.x, position.y, 65, 110);
    }

    /**
     * @return velocity
     */
    public Vector3 getVelocity() {
        return velocity;
    }

    /**
     * Sets the texture of the villain
     * @param vil Texture of villain
     */
    public void setTexture(Texture vil){
        villain = vil;
    }

    /**
     * @return Position of the villain
     */
    public Vector3 getPosition() {
        return position;
    }

    /**
     * Sets position of the villain
     * @param position Position of the villain
     */
    public void setPosition( Vector3 position) {
        this.position = position;
    }

    /**
     * @return Texture of villain
     */
    public Texture getTexture() {
        return villain;
    }

    /**
     * @return Bounds that represents the villain
     */
    public Rectangle getBounds(){
        return bounds;
    }

    /**
     * Checks whether the minion has collided with the villain
     * @param minion
     * @return true if collided
     */
    public boolean collides(Rectangle minion) {

        return minion.overlaps(bounds);

    }

    /**
     * Method responsible for replacing the villain of 10000 in 10000 positions
     * @param newVillain
     */
    public void reposition(Villain newVillain){
        Random rand = new Random();
        float y=newVillain.getPosition().y+10000;
        float x = rand.nextInt(MyMinionJump.WIDTH);
        Vector3 v = new Vector3(x,y,0);
        newVillain.setPosition(v);
        bounds.setPosition(x,y);
    }

    /**
     * Disposes villain
     */
    public void dispose() {
        villain.dispose();
    }

}
