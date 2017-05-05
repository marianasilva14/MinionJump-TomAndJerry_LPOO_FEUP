package com.minionjump.game.model;

import com.minionjump.game.model.entities.MinionModel;
import com.minionjump.game.model.entities.PlatformModel;
import com.minionjump.game.model.entities.VillainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariana on 05/05/2017.
 */

public class GameModel {

    private MinionModel minion;
    private VillainModel villain;

    private List<PlatformModel> platforms;

    public GameModel(float x, float y){
        platforms= new ArrayList<PlatformModel>();
        minion= new MinionModel(x,y);
    }


    public MinionModel getMinion(){
        return minion;
    }

    public VillainModel getVillain(){
        return villain;
    }

    public List<PlatformModel> getPlatforms(){
        return platforms;
    }
}

