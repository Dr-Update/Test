package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject {
	public float x = 0;
	public float y = 0;
	
	private Texture texture;
	private SpriteBatch spriteBatchHandle;
	
	
	public GameObject(String texPath, SpriteBatch batch, float posX, float posY) {
		spriteBatchHandle = batch;
		texture = new Texture (texPath);
		x = posX;
		y = posY;
	}
	
	public void updatePosition() {
		int speed = 1;
		x += GameInput.keyInput.x * speed * Time.time;
		y += GameInput.keyInput.y * speed * Time.time;
	}
	public void Draw() {
		spriteBatchHandle.draw(texture, x, y);
		}
	}
