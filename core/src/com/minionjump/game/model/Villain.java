package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.view.GameStateManager;

import java.util.Random;

/**
 * Created by Sissi on 26/05/2017.
 */

public class Villain{

    private Vector3 position;
    private float minHeight;

    public Vector3 getVelocity() {
            return velocity;
        }

    private Vector3 velocity;
    private Rectangle bounds;
    private GameStateManager game;
    private Texture villain;
    public boolean visible;

    public Villain(int x, int y,GameStateManager gam){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        villain = new Texture("villain.png");
        bounds = new Rectangle(x, y, villain.getWidth(), villain.getHeight());
        minHeight=0;
        game=gam;
        visible=false;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition( Vector3 position) {
        this.position = position;
    }

    public Texture getTexture() {
        return villain;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public boolean collides(Rectangle minion) {

        return minion.overlaps(bounds);

    }

    public void reposition(Villain newVillain){
        Random rand = new Random();
        float y=newVillain.getPosition().y+10000;
        float x = rand.nextInt(MyMinionJump.WIDTH);
        Vector3 v = new Vector3(x,y,0);
        newVillain.setPosition(v);
        bounds.setPosition(x,y);
    }

    public void dispose() {
        villain.dispose();
    }

}
