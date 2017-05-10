package com.minionjump.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.minionjump.game.MyMinionJump;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MyMinionJump.WIDTH;
		config.height = MyMinionJump.HEIGHT;
		config.title = MyMinionJump.TITLE;
		new LwjglApplication(new MyMinionJump(), config);
	}
}
