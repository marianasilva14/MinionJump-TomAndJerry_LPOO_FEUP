package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.Platform;

/**
 * Created by Mariana on 10/05/2017.
 */

public class PlayState extends State {
    private static final int PLATFORM_SPACING = 100;
    private static final int PLATFORM_COUNT = 6;

    private Minion minion;
    private Texture bg;

    private Array<Platform> platforms;

    public PlayState(GameStateManager gam) {
        super(gam);
        minion = new Minion(150, 300);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        bg = new Texture("background.png");

        platforms = new Array<Platform>();

        for(int i = 1; i < PLATFORM_COUNT; i++){
            platforms.add(new Platform(i * (PLATFORM_SPACING + Platform.PLATFORM_HEIGHT)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            minion.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        minion.update(dt);
        cam.position.y = minion.getPosition().y + 80;

        for(int i = 0; i < platforms.size; i++){
            Platform platform = platforms.get(i);

            if(cam.position.x - (cam.viewportWidth / 2) > platform.getPosNormalPlatform().x + platform.getNormalPlatform().getWidth())
                platform.reposition(platform.getPosNormalPlatform().x + ((Platform.PLATFORM_HEIGHT + PLATFORM_SPACING) * PLATFORM_COUNT));

            if(platform.collides(minion.getBounds()))
                minion.jump();
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix((cam.combined));
        sb.begin();
        sb.draw(bg, 0, cam.position.y - (cam.viewportHeight / 2));
        sb.draw(minion.getTexture(), minion.getPosition().x, minion.getPosition().y);
        for(Platform platform : platforms) {
            sb.draw(platform.getNormalPlatform(), platform.getPosNormalPlatform().x, platform.getPosNormalPlatform().y);
            sb.draw(platform.getSplitPlatform(), platform.getPosSplitPlatform().x, platform.getPosSplitPlatform().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        minion.dispose();
        for(Platform platform : platforms)
            platform.dispose();
        System.out.println("Play State Disposed");
    }
}
