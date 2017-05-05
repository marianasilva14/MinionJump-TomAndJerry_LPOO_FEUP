package com.minionjump.game.model.entities;

/**
 * Created by Mariana on 05/05/2017.
 */

public class PlatformModel extends EntityModel{

    public enum PlatformType{ NORMAL, SPLIT, SPRING, ROCKET};

    private PlatformType type;

    public PlatformModel(float x, float y,PlatformType type ){
        super(x,y);

        this.type=type;
    }

    public PlatformType getType(){
        return this.type;
    }


}
