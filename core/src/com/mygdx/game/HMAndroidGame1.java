package com.mygdx.game;

/**
 * HomeWork 1
 * @author Ievlev Andrey
 * @version April 6, 2018
 * @Link 
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class HMAndroidGame1 extends ApplicationAdapter {
	SpriteBatch batch;
	Asteroid asteroids[] = new Asteroid[10];
	float rndx [] = new float[10];
	float rndy [] = new float[10];
	float rndVX [] = new float[10];
	float rndVY [] = new float[10];


	@Override
	public void create () {
		batch = new SpriteBatch();
		for (int i = 0; i < rndx.length ; i++) {
			rndx[i] = MathUtils.random(0.0f, 1200.0f);
		}
		for (int i = 0; i < rndy.length ; i++) {
			rndy[i] = MathUtils.random(0.0f, 700.0f);
		}
		for (int i = 0; i < rndVX.length ; i++) {
			rndVX[i] = MathUtils.random(-200.0f, 200.0f);
		}
		for (int i = 0; i < rndVY.length ; i++) {
			rndVY[i] = MathUtils.random(-200.0f, 200.0f);
		}
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid(rndx[i] ,rndy[i] ,rndVX[i],rndVY[i]);
		}
		}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (Asteroid asteroid : asteroids) {
			asteroid.render(batch);
		}
		batch.end();

	}

	public void update(float dt){
		for (Asteroid asteroid : asteroids) {
			if (Gdx.input.isTouched()) {
				asteroid.position.set(Gdx.input.getX(), 720 - Gdx.input.getY());
				asteroid.velocity.set(0, 0);
			}
			asteroid.update(dt);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
