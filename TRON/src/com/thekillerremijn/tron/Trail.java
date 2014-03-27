package com.thekillerremijn.tron;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Trail {

	private ShapeRenderer shape;
	public List<Vector2> points;
	public Color color;
	private Map map;
	
	public Trail(Map map){
		shape = new ShapeRenderer();
		points = new ArrayList<Vector2>();
		this.map = map;
	}
	
	public void render(float delta){
		if(points.size() < 2) return;
		

		shape.begin(ShapeType.Line);
		shape.setColor(color);
		
		
		//draw polyline
		Polyline line = new Polyline(toPolyLine());
		
		line.setOrigin(map.x, map.y);
		line.setScale(map.width / 100, map.height / 100);
		
		//shape.polyline(line.getTransformedVertices());
		
		
		//draw individual lines
		for(int i=0;i<points.size();i++){
			if(i+1 >= points.size()) break;
			float x1 = map.width*(points.get(i).x/100)+map.x;
			float y1 = map.height*(points.get(i).y/100)+map.y;
			float x2 = map.width*(points.get(i+1).x/100)+map.x;
			float y2 = map.height*(points.get(i+1).y/100)+map.y;
			shape.line(x1, y1, x2, y2);
		}
		
		shape.end();
	}
	
	public float[] toPolyLine(){
		
		float[] ret = new float[points.size()*2];
		
		for(int i=0;i<points.size();i++){
			ret[i*2] = points.get(i).x;
			ret[i*2+1] = points.get(i).y;
		}
		
		return ret;
	}
	
	public void addPoint(Vector2 point){
		points.add(point);
	}
	
	public boolean intersects(Rectangle rect){
		boolean ret = false;
		for(int i=0;i<points.size();i++){
			if(rect.contains(points.get(i)) && i < points.size() - 10) ret = true;
		}
		return ret;
	}
}
