package com.minionjump.game.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Class responsible for animation of platforms
 */
public class Animation {
    /**
     * Is at end?
     */
    private boolean atEnd = false;
    /**
     * Array of frames
     */
    private Array<TextureRegion> frames;
    /**
     * Maximum frame time
     */
    private float maxFrameTime;
    /**
     * Current frame time
     */
    private float currentFrameTime;
    /**
     * Count for frame
     */
    private int frameCount;
    private int frame;

    /**
     * Constructs for image animation
     * @param region
     * @param frameCount
     * @param cycleTime
     */
    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;

        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i* frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    /**
     * Updates the animation
     * @param dt
     */
    public void update(float dt){
        currentFrameTime += dt;

        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = frameCount-1;
            atEnd = true;
        }

    }

    /**
     * Checks if the animatin is at end.
     * @return true if animation is at end
     */
    public boolean isAtEnd(){
        return atEnd;
    }

    /**
     * @return frame
     */
    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
