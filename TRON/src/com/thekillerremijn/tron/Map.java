package com.thekillerremijn.tron;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.thekillerremijn.tron.screens.TronScreen;
import com.thekillerremijn.tron.screens.VictoryScreen;

public class Map {
	
	private ShapeRenderer shape;
	
	private TronScreen screen;
	
	public float x;
	public float y;
	public float width;
	public float height;

	Player player1;
	Player player2;

	public Map(TronScreen screen){
		
		this.screen = screen;
		
		shape = new ShapeRenderer();
		player1 = new Player(this, Color.BLUE);
		player2 = new Player(this ,Color.RED);

		reset();
	}

	public void render(float delta){
		//draw outline to the map
		shape.begin(ShapeType.Line);
		shape.setColor(Color.GREEN);
		shape.rect(x, y, width, height);
		shape.rect(x-1, y-1, width+2, height+2);
		shape.end();
		
		
		if(screen.inForeGround()){
			//check aliviness of the players
			if(player1.isDead){
				player2.score++;
				victory(player2, 2);
			}
			if(player2.isDead){
				player1.score++;
				victory(player1, 1);
			}
			
			player1.handleInput(delta);
			player2.handleInput(delta);
		}
		
		

		player1.render(delta);
		player2.render(delta);
	}
	
	public boolean containsTrail(Rectangle rect){
		return (player1.trail.intersects(rect) && !player1.isDead) || (player2.trail.intersects(rect) && !player2.isDead);
	}
	
	public void victory(Player winner, int player){
		VictoryScreen victoryScreen = new VictoryScreen(screen, (Game)TRONGame.getInstance());
		victoryScreen.text = "Player" + player + " Has Won!";
		victoryScreen.textColor = winner.color;
		TRONGame.getInstance().setScreen(victoryScreen);
	}

	public TronScreen reset() {
		player1.controls = Controls.player1;
		player2.controls = Controls.player2;
		
		player1.startlocation = new Vector2(10, 10);
		player1.startrotation = 0;
		
		player2.startlocation = new Vector2(90, 90);
		player2.startrotation = 180;
		
		player1.reset();
		player2.reset();
		
		return screen;
	}

}
