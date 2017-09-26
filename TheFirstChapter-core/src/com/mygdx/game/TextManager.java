package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;


public class TextManager {
	private static BitmapFont bFont = new BitmapFont();
	private static SpriteBatch spriteBatchHandle;
	
	public static void setSpriteBatch(SpriteBatch batch) {
		bFont.setColor(Color.RED);
		spriteBatchHandle = batch;
	}
	
	public static void Draw(java.lang.CharSequence msg, OrthographicCamera cam) {
		Vector3 position = new Vector3(10, 20, 0);
		cam.unproject(position);
		bFont.draw(spriteBatchHandle, msg, position.x, position.y);
	}
}
