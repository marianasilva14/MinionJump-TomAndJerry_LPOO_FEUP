package com.minionjump.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.minionjump.game.view.GameOverMenu;
import com.minionjump.game.view.GameStateManager;
import com.minionjump.game.view.PlayState;

/**
 * Created by Mariana on 10/05/2017.
 */

public class Minion {
    private static  final int GRAVITY = -15;
    private static  final int MOVEMENT = 100;
    private Vector3 position;
    private float minHeight;

    public Vector3 getVelocity() {
        return velocity;
    }

    private Vector3 velocity;
    private Rectangle bounds;
   private GameStateManager game;
    private Texture minion;

    public Minion(int x, int y,GameStateManager gam){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        minion = new Texture("minion.png");
        bounds = new Rectangle(x, y, minion.getWidth(), minion.getHeight());
        minHeight=0;
        game=gam;
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
                game.set(new GameOverMenu(game));
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

    public void jump(int number){
        velocity.y = number;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose() {
        minion.dispose();
    }
}
