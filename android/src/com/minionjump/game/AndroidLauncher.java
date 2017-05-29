package com.minionjump.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.minionjump.game.MyMinionJump;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		MyMinionAndroidPreference prefs = new MyMinionAndroidPreference(this);
		initialize(new MyMinionJump(prefs), config);
	}
}
