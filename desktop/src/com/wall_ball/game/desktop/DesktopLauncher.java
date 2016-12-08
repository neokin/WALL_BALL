package com.wall_ball.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.wall_ball.game.WALL_BALL;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 480;
		config.width = 800;
		config.title = "WallBall";

		new LwjglApplication(new WALL_BALL(), config);
	}
}
