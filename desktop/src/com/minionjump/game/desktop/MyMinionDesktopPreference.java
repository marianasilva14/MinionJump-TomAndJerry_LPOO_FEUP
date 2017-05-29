package com.minionjump.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.minionjump.game.MyMinionPreference;
import com.minionjump.game.controller.GameController;

/**
 * Created by Sissi on 27/05/2017.
 */

public class MyMinionDesktopPreference implements MyMinionPreference {
    public Preferences getPrefs(){
        return Gdx.app.getPreferences("scores");
    }

    @Override
    public int getScore() {
        return getPrefs().getInteger("highscore",0);
    }

    @Override
    public void setScore(int score) {
        getPrefs().putInteger("highscore",score);
    }
}
