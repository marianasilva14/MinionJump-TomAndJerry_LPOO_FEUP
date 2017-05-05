package com.minionjump.game.model.entities;

/**
 * Created by Mariana on 05/05/2017.
 */

public class MinionModel extends EntityModel{

    private boolean accelarating=true;

    public MinionModel(float x, float y){
        super(x,y);
    }

    public void setAccelarating(boolean accelarating){
        this.accelarating=accelarating;
    }

    public boolean isAccelarating(){
        return accelarating;
    }
}
