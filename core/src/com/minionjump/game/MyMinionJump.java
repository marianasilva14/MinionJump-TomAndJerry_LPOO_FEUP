package com.minionjump.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ArrayMap;
import com.minionjump.game.view.GameStateManager;
import com.minionjump.game.view.MainMenu;

/**
 * The game main class
 */
public class MyMinionJump extends ApplicationAdapter {
	/**
	 * Screen height
	 */
	public static final int HEIGHT = 800;
	/**
	 * Screen width
	 */
	public static final int WIDTH = 480;
	/**
	 * Hud height
	 */
	public static final int V_HEIGHT = 800;
	/**
	 * Hud width
	 */
	public static final int V_WIDTH = 480;

	/**
	 * Create a Sprite batch
	 */
	public static SpriteBatch batch;
	/**
	 * Create a Game state Manager
	 */
	public GameStateManager gam;

	/**
	 * Game Title
	 */
	public static final String TITLE = "Minion Jump";
	private ArrayMap assetManager;
	public static MyMinionPreference prefs;

	/**
	 * Game music
	 */
	public static Music music;

	/**
	 * Constructs the main class
	 * @param prefs preferences
	 */
	public MyMinionJump(MyMinionPreference prefs){
		super();
		this.prefs = prefs;
	}

	/**
	 * Calls the main menu and initializes the game
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		gam = new GameStateManager();
		music= Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(2f);
		Gdx.gl.glClearColor(1,0,0,1);
		gam.push(new MainMenu(gam));
	}

	/**
	 * Renders the game
	 */
	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gam.update(Gdx.graphics.getDeltaTime());
		gam.render(batch);
	}

	/**
	 * Disposes the game and music
	 */
	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}


	/**
	 * Get's the asset manager
	 * @return assetManager
	 */
	public ArrayMap getAssetManager() {
		return assetManager;
	}
}
