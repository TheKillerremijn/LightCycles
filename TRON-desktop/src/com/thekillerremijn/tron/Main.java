package com.thekillerremijn.tron;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TRON";
		cfg.useGL20 = false;
		cfg.width = 500;
		cfg.height = 500;
		
		new LwjglApplication(new TRONGame(), cfg);
	}
}
