package com.minionjump.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ArrayMap;
import com.minionjump.game.view.GameStateManager;
import com.minionjump.game.view.MainMenu;

public class MyMinionJump extends ApplicationAdapter {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 480;

	public SpriteBatch batch;
	public GameStateManager gam;
	public static final String TITLE = "Minion Jump";
	private ArrayMap assetManager;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gam = new GameStateManager();
		Gdx.gl.glClearColor(1,0,0,1);
		gam.push(new MainMenu(gam));
	}

	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gam.update(Gdx.graphics.getDeltaTime());
		gam.render(batch);
	}


	public ArrayMap getAssetManager() {
		return assetManager;
	}
}
