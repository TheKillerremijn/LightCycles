package com.thekillerremijn.tron.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.thekillerremijn.tron.Art;
import com.thekillerremijn.tron.Controls;
import com.thekillerremijn.tron.TRONGame;
import com.thekillerremijn.tron.screens.TronScreen;

public class Button {

	ShapeRenderer shape;
	SpriteBatch batch;
	
	public String text;
	public float x;
	public float y;
	public float width;
	public float height;
	
	boolean clicked = true;
	
	public TronScreen toOpen;
	
	public Button(){
		this.shape = new ShapeRenderer();
		this.batch = new SpriteBatch();
	}
	
	public void render(float delta){
		
		//first draw the contents, then the outlines, then the text
		shape.begin(ShapeType.Filled);
		shape.setColor(Color.BLACK);
		shape.rect(x-width/2, y-height/2, width, height);
		shape.end();
		
		//now draw the green outline
		shape.begin(ShapeType.Line);
		shape.setColor(Color.GREEN);
		shape.rect(x-width/2, y-height/2, width, height);
		shape.end();
		
		//now draw the text
		Art.roboto.setColor(Color.GREEN);
		Art.roboto.setScale(0.2f);
		TextBounds bounds = Art.roboto.getBounds(text);

		
		batch.begin();
		Art.roboto.draw(batch, text, x-bounds.width/2, y+bounds.height/2);
		batch.end();
		
		//check for input
		if(Gdx.input.isTouched()){
			//if it is not held down
			if(clicked == false){
				clicked = true;
								
				//mouse is hovering over the button
				if(new Rectangle(x - width/2, y - height/2, width, height).contains(Controls.getPointer())){
					clicked();
				}
			}
		}else{
			clicked = false;
		}
	}
	
	public void clicked(){
		try {
			if(toOpen != null)
				TRONGame.getInstance().setScreen(toOpen);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
