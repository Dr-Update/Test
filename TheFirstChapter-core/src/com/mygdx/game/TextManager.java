package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;


public class TextManager {
	private static BitmapFont bFont = new BitmapFont();
	private static SpriteBatch spriteBatchHandle;
	private static OrthographicCamera orthoCam; 
	
	public static void setSpriteBatch(SpriteBatch batch , OrthographicCamera cam) {
		orthoCam = cam;
		bFont.setColor(Color.RED);
		spriteBatchHandle = batch;
	}
	
	public static void Draw(java.lang.CharSequence msg, float x, float y) {
		Vector3 position = new Vector3(x, y, 0);
		orthoCam.unproject(position);
		bFont.draw(spriteBatchHandle, msg, position.x, position.y);
	}
}
