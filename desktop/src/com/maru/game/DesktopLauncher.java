package com.maru.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public final static int SCREEN_WIDTH = 1200;
	public final static int SCREEN_HEIGHT = 840;
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Mario Bros");
		config.setWindowedMode(SCREEN_WIDTH,SCREEN_HEIGHT);
		config.setResizable(false);
		new Lwjgl3Application(new MarioBros(), config);
	}
}
