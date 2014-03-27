package com.thekillerremijn.tron.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.thekillerremijn.tron.*;

public class GameScreen extends TronScreen {

	Map map;

	public GameScreen(Game game) {
		super(game);
		map = new Map(this);
		map.width = Gdx.graphics.getWidth() * 0.9f;
		map.height = map.width;
		
		if(Gdx.graphics.getWidth() > Gdx.graphics.getHeight()){
			map.height = Gdx.graphics.getHeight() * .9f;
			map.width = map.height;
			
		}
		
		map.x = (Gdx.graphics.getWidth() - map.width) / 2;
		map.y = (Gdx.graphics.getHeight() - map.height) / 2;
	}

	public void render(float delta){
		super.render(delta);
		if(TRONGame.running == false) delta = 0;
		
		map.render(delta);

	}

}
