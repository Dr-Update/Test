package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{
	private static float frames;
	public static float gravity;
	private Vector2 gravityVector = new Vector2(0,-1);
	private Vector2 momentum = new Vector2(0,0);
	
	public Player(Texture texture, float x, float y) {
		this.setTexture(texture);
		this.setPosition(x, y);
	}

	public void Update() {
		int speed  = 3;
		frames = Gdx.graphics.getFramesPerSecond();
		frames = (frames == 0) ? 144 : frames;
		gravity = 12f / frames;

		
		if(this.getY()<= 50) {
			momentum.y = 0;		
			if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
	//			momentum.y = gravity * 55;
				momentum.set(gravity * 55 * -1 * gravityVector.x , gravity * 55 * 1 * gravityVector.y );
			}
		}else {
			momentum.add(gravity * gravityVector.x,  gravity * gravityVector.y);
		}

	//	momentum.x = GameInput.keyInput.x * speed;

		
		this.translateX(momentum.x * (float)Time.time);
		this.translateY(momentum.y * (float)Time.time);
		
		this.setY(Math.max(this.getY(),50));
	}
	
	@Override
	public void draw(Batch batch) {
	 batch.draw(this.getTexture(),this.getX(), this.getY());	
	}
}
