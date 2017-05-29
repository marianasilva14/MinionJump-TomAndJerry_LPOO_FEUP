package com.minionjump.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

/**
 * Created by Sissi on 27/05/2017.
 */

public class MyMinionAndroidPreference implements MyMinionPreference {
    Handler handler;
    Context context;

    public MyMinionAndroidPreference(Context context){
        handler = new Handler();
        this.context=context;
    }
    @Override
    public int getScore() {
        SharedPreferences prefs = context.getSharedPreferences("scores",Context.MODE_PRIVATE);
        int score= prefs.getInt("highscore",0);
        return score;
    }

    @Override
    public void setScore(int score) {
        SharedPreferences.Editor editor = context.getSharedPreferences("scores",context.MODE_PRIVATE).edit();
        editor.putInt("highscore",score);
        editor.commit();
    }
}
