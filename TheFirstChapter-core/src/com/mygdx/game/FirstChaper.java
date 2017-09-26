package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class FirstChaper extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameObject object;
	
	//Level 
	float width;
	float height;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	int levelPixelWidth;
	int levelPixelHeight;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		//Camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false,width,height);
		camera.update();
		
		//Level Laden
		tiledMap = new TmxMapLoader().load("F:\\Eclipse Ox\\GameDev\\FirstChaper\\Maps\\testlvl.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		
		TextManager.setSpriteBatch(batch);
		
		img = new Texture("F:\\Eclipse Ox\\GameDev\\FirstChaper\\Maps\\terraria.png");
		object = new GameObject(img, batch, 0, 0);
		
		MapProperties properties = tiledMap.getProperties();
		int levelWidth = properties.get("width", Integer.class);
		int levelHeight = properties.get("height", Integer.class);
		int tilePixelWidth = properties.get("tilewidth", Integer.class);
		int tilePixelHeight = properties.get("tileheight", Integer.class);
		levelPixelWidth = levelWidth * tilePixelWidth;
		levelPixelHeight = levelHeight * tilePixelHeight;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		
		GameInput.Update();
		object.updatePosition();
		//camera.position.set(object.x, object.y, 0);
		camera.position.x = Math.min(Math.max(object.x, width / 2),levelPixelWidth - (width / 2));
		camera.position.y = Math.min(Math.max(object.y, height / 2),levelPixelHeight - (height / 2));
		camera.update();
		Time.update();
		
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		
		batch.begin();
		
		batch.setProjectionMatrix(camera.combined);
		object.Draw();
		
		TextManager.Draw("X " + object.x + "  Y: " + object.y, camera);
	
		batch.end();
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
	}
}
