package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public  class GameInput {

	public static Vector2 keyInput = new Vector2();
	
	public static void Update() {
		keyInput.x = 0;
		keyInput.y = 0;
		if(Gdx.input.isKeyPressed(Input.Keys.W)) keyInput.y += 1;
		if(Gdx.input.isKeyPressed(Input.Keys.S)) keyInput.y -= 1;
		if(Gdx.input.isKeyPressed(Input.Keys.A)) keyInput.x -= 1;
		if(Gdx.input.isKeyPressed(Input.Keys.D)) keyInput.x += 1;
		
	}
}
