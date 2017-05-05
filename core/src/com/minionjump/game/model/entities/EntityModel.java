package com.minionjump.game.model.entities;

/**
 * Created by Mariana on 05/05/2017.
 */

public abstract class EntityModel {

    private float x;

    private float y;

    EntityModel(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setX(float x){
        this.x=x;
    }

    public void setY(float y){
        this.y=y;
    }


}
