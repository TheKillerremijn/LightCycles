package com.thekillerremijn.tron.screens;

import java.util.concurrent.Callable;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thekillerremijn.tron.Art;
import com.thekillerremijn.tron.TRONGame;
import com.thekillerremijn.tron.ui.Button;

public class VictoryScreen extends TronScreen{
	
	Screen parent;
	Button restart;
	Button exit;
	
	SpriteBatch batch;
	
	public String text;
	public Color textColor;

	public VictoryScreen(Game game) {
		super(game);
	}
	
	public VictoryScreen(final Screen parent, Game game){
		super(game);
		this.parent = parent;
		
		batch = new SpriteBatch();
		
		restart = new Button();
		exit = new Button();
		
		restart.text = "Restart";
		restart.x = Gdx.graphics.getWidth() / 2;
		restart.y = Gdx.graphics.getHeight() / 2 + 50;
		restart.width = 200;
		restart.height = 70;
		restart.toOpen = ((GameScreen)parent).map.reset();
		
		
		exit.text = "Main Menu";
		exit.x = Gdx.graphics.getWidth() / 2;
		exit.y = Gdx.graphics.getHeight() / 2 - 50;
		exit.width = 200;
		exit.height = 70;
		exit.toOpen = new MenuScreen(TRONGame.getInstance());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		parent.render(0); //render parent screen with delta 0, making it paused
		
		restart.render(delta);
		exit.render(delta);
		
		Art.roboto.setColor(textColor);
		Art.roboto.setScale(0.4f);
		
		TextBounds bounds = Art.roboto.getBounds(text);
		
		batch.begin();
		Art.roboto.draw(batch, text, Gdx.graphics.getWidth()/2-bounds.width/2, Gdx.graphics.getHeight() / 2 + 200);
		batch.end();
		
	}
	
}
