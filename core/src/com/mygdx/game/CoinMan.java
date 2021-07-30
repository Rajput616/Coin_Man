package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class CoinMan extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] man;
	int manState = 0;
	int pause = 0;

	float gravity = 0.8f;
	float velocity = 0;
	int manY = 0;



	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");

		man = new Texture[4];
		man[0] = new Texture("frame1.png");
		man[1] = new Texture("frame2.png");
		man[2] = new Texture("frame3.png");
		man[3] = new Texture("frame4.png");

		manY = Gdx.graphics.getHeight() / 2;
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if(Gdx.input.justTouched()){
			velocity = -15;
		}

		if(pause < 6){
			pause++;
		} else {
			pause = 0;
			if (manState < 3) {
				manState++;
			} else {
				manState = 0;
			}
		}

		velocity += gravity;
		manY -= velocity;

		if(manY <= 0){
			manY = 0;
		}


		batch.draw(man[manState], Gdx.graphics.getWidth() / 2 - man[manState].getWidth()/2, manY);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
