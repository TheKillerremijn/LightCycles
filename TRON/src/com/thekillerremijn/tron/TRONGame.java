package com.thekillerremijn.tron;

import com.badlogic.gdx.Game;
import com.thekillerremijn.tron.screens.*;

public class TRONGame extends Game{

	public static boolean running = true;
	private static TRONGame instance;

	@Override
	public void create() {
		TRONGame.instance = this;
		Art.load();
		Controls.load();
		//TODO Load Sounds
		MenuScreen menu = new MenuScreen(this);
		setScreen(menu);
		
	}
	
	public static TRONGame getInstance(){
		return instance;
	}
}
