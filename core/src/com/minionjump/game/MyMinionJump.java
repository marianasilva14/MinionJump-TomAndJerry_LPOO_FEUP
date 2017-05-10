package com.minionjump.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.minionjump.game.States.GameStateManager;
import com.minionjump.game.States.MenuState;

public class MyMinionJump extends ApplicationAdapter {
	public static final int HEIGHT = 800;
	public static final int WIDTH = 480;

	private SpriteBatch batch;
	private GameStateManager gam;
	public static final String TITLE = "Minion Jump";
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gam = new GameStateManager();
		Gdx.gl.glClearColor(1,0,0,1);
		gam.push(new MenuState(gam));
	}

	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gam.update(Gdx.graphics.getDeltaTime());
		gam.render(batch);
	}


}
