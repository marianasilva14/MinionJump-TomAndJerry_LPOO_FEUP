package com.minionjump.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.model.Minion;
import com.minionjump.game.model.Platform;

/**
 * Created by Mariana on 10/05/2017.
 */

public class PlayState extends State {
    private static final int PLATFORM_SPACING = 100;
    private static final int PLATFORM_COUNT = 5;

    private Minion minion;
    private Texture bg;

    private Array<Platform> platforms;

    public PlayState(GameStateManager gam) {
        super(gam);
        minion = new Minion(150, 300,gam);
        cam.setToOrtho(false, MyMinionJump.WIDTH, MyMinionJump.HEIGHT);
        bg = new Texture("background.png");

        platforms = new Array<Platform>();

        for(int i = 1; i < PLATFORM_COUNT; i++){
            platforms.add(new Platform(i * (PLATFORM_SPACING + Platform.PLATFORM_HEIGHT)));
        }
    }

    @Override
    protected void handleInput() {
        /*
        if(Gdx.input.justTouched())
            minion.jump();
            */
        Vector3 new_position = minion.getPosition();

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            new_position.x-=15;
            minion.setPosition(new_position);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            new_position.x+=15;
            minion.setPosition(new_position);
        }
     if(Gdx.input.getAccelerometerX() != 0){
            new_position.x-=Gdx.input.getAccelerometerX()/1.2f;
        }



        //new_position.x+= Gdx.input.getAccelerometerX()/10;
        //System.out.println( Gdx.input.getAccelerometerX());


      if(minion.getPosition().x > MyMinionJump.WIDTH){
          new_position.x = 0 ;
          minion.setPosition(new_position);
      }
        if(minion.getPosition().x < 0){
            new_position.x = MyMinionJump.WIDTH-10;
            minion.setPosition(new_position);
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        minion.update(dt);
        cam.position.y = minion.getPosition().y + 80;

        for(int i = 0; i < platforms.size; i++){
            Platform platform = platforms.get(i);

            if(cam.position.y - (cam.viewportHeight / 2) > platform.getPosNormalPlatform().y + platform.getNormalPlatform().getHeight())
                platform.reposition(platform.getPosNormalPlatform().y + ((Platform.PLATFORM_HEIGHT + PLATFORM_SPACING) * PLATFORM_COUNT));

           if(platform.collides(minion.getBounds())) {
               if (minion.getVelocity().y < 0)
                   minion.jump();
           }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
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
