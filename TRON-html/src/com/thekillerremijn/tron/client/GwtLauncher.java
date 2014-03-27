package com.thekillerremijn.tron.client;

import com.thekillerremijn.tron.TRONGame;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(500, 500);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new TRONGame();
	}
}