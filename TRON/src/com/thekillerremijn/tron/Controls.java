package com.thekillerremijn.tron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Controls {

	public static ControlScheme player1;
	public static ControlScheme player2;
	
	public static void load(){
		player1 = new ControlScheme();
		player2 = new ControlScheme();
		
		player2.LEFT = Keys.DPAD_LEFT;
		player2.RIGHT = Keys.DPAD_RIGHT;
		
	}
	
	public static Vector2 getPointer(){
		float x = Gdx.input.getX();
		float y = (Gdx.input.getY() * -1) + Gdx.graphics.getHeight();
		return new Vector2(x, y);
	}
	
}
