package com.thekillerremijn.tron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private Map map;
	SpriteBatch batch;
	
	public Vector2 location;
	public Vector2 startlocation;
	public float size = 3;
	public float rotation;
	public float startrotation;
	public Color color;
	
	public boolean isDead = false;
	
	public float speed = 20;
	public float rspeed = 230;
	
	public int score = 0;
	
	public ControlScheme controls;
	
	public Trail trail;
	
	public Player(Map map, Color color){
		this.map = map;
		this.color = color;
		batch = new SpriteBatch();
		trail = new Trail(map);
		trail.color = color;
	}
	
	public void handleInput(float delta){
		
		if(isDead) return;
		
		//Rotate the player based on input
		if(Gdx.input.isKeyPressed(controls.LEFT)) rotation += rspeed*delta;
		if(Gdx.input.isKeyPressed(controls.RIGHT)) rotation -= rspeed*delta;
		
		Vector2 movement = new Vector2();
		movement.y = 1;
		movement.rotate(rotation);
		movement.scl(delta * speed);
		location.add(movement);
		if(checkCollisions(location)){
			die();
		}
		if(delta != 0) updateTrail();
	}
	
	public void updateTrail(){
		trail.addPoint(location.cpy().add(size/2, size/2));
	}

	public boolean checkCollisions(Vector2 location){
		if(location.x+size > 100 || location.x < 0 || location.y+size > 100 || location.y < 0){
			return true;
		}
		
		//TODO check collisions with other players and trails and stuff...
		
		if(map.containsTrail(new Rectangle(location.x, location.y, size, size))) 
			return true;
		
		return false;
	}
	
	public void render(float delta){
		if(isDead) return;
		
		batch.begin();
		batch.setColor(color);
		batch.draw(Art.LightCycle, map.width*(location.x/100)+map.x, map.height*(location.y/100)+map.y, (map.width*(size/100))/2, (map.height*(size/100))/2, map.width*(size/100), map.height*(size/100), 1, 1, rotation+180);
		batch.end();
		
		trail.render(delta);
	}
	
	public void die(){
		isDead = true;
		//draw shiny particles and shit
	}
	
	public void reset(){
		trail = new Trail(map);
		trail.color = color;
		
		isDead = false;
		
		location = startlocation;
		rotation = startrotation;
	}
}