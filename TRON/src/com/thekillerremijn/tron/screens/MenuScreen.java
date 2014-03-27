package com.thekillerremijn.tron.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.thekillerremijn.tron.Art;
import com.thekillerremijn.tron.TRONGame;
import com.thekillerremijn.tron.ui.Button;

public class MenuScreen extends TronScreen{

	Button play;
	
	SpriteBatch batch;
	
	public String text;
	
	public MenuScreen(Game game){
		super(game);
		
		batch = new SpriteBatch();
		
		play = new Button();
		
		text = "TRON";
		
		play.text = "Play!";
		play.x = Gdx.graphics.getWidth() / 2;
		play.y = Gdx.graphics.getHeight() / 2 + 50;
		play.width = 200;
		play.height = 70;
		play.toOpen = new GameScreen(TRONGame.getInstance());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		
		play.render(delta);
		
		Art.roboto.setColor(Color.GREEN);
		Art.roboto.setScale(0.7f);
		
		TextBounds bounds = Art.roboto.getBounds(text);
		
		batch.begin();
		Art.roboto.draw(batch, text, Gdx.graphics.getWidth()/2-bounds.width/2, Gdx.graphics.getHeight() / 2 + 200);
		batch.end();
		
	}

}
