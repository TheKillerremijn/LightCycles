package com.thekillerremijn.tron;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Art {

	public static TextureRegion LightCycle;
	public static BitmapFont roboto;

	public static void load(){
		roboto = loadFont("data/fonts/roboto.fnt");
		LightCycle = load("data/textures/lightcycle.png", 64, 64);
	}

	@SuppressWarnings("unused")
	private static TextureRegion[][] split (String name, int width, int height) {
		Texture texture = new Texture(Gdx.files.internal(name));
		int xSlices = texture.getWidth() / width;
		int ySlices = texture.getHeight() / height;
		TextureRegion[][] res = new TextureRegion[xSlices][ySlices];
		for (int x = 0; x < xSlices; x++) {
			for (int y = 0; y < ySlices; y++) {
				res[x][y] = new TextureRegion(texture, x * width, y * height, width, height);
			}
		}
		return res;
	}

	public static TextureRegion load (String name, int width, int height) {
		Texture texture = new Texture(Gdx.files.internal(name));
		TextureRegion region = new TextureRegion(texture, 0, 0, width, height);
		region.flip(false, true);
		return region;
	}
	
	private static BitmapFont loadFont(String path) {
		BitmapFont font = new BitmapFont(Gdx.files.internal(path), false);
		return font;
	}
}
