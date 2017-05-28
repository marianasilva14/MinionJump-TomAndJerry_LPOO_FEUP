package com.minionjump.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.minionjump.game.MyMinionJump;
import com.minionjump.game.MyMinionPreference;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new MyMinionJump(new MyMinionPreference() {
                        @Override
                        public int getScore() {
                                return 0;
                        }

                        @Override
                        public void setScore(int score) {

                        }
                });
        }
}