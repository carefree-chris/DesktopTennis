package com.christopher.tennis;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DesktopTennis extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	//Can't put these in the render class, since that's a loop.
	private int imgX = 0;
	private int imgY = 0;
	private int upOrDown = 1;
	private int leftOrRight = 1;
	
	private int count = 2000;
	
	
	//TODO: Remove
	private long startTime = System.currentTimeMillis();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		//These two lines run every time.
		Gdx.gl.glClearColor(0.5f, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/* I don't know how to use this.
		float time = (Gdx.graphics.getDeltaTime() * 100);
		System.out.println("Test " + time);
		*/
		
		//Had to look up how to measure time.
		long currentTime = (System.currentTimeMillis() - startTime);
		System.out.println("test: " + currentTime);
		if (currentTime == count) {
			System.out.println("This program has been running " + (currentTime / 1000) + " seconds.");
			count += 2000;
		}
		
		batch.begin(); //Start, preparation. All drawing code below.
		
		
		//Keeps it bouncing up and down.
		if (imgY >= 230) {
			
			upOrDown = -1;
		} else if (imgY == 0 || imgY < 0) {
			
			upOrDown = 1;
		}
		
		imgY += upOrDown; //Movement.
		
		//Keeps it bouncing left and right.
		if (imgX <= 0) {
			leftOrRight = 1;
		} else if (imgX >= 390) {
			leftOrRight = -1;
		}
		
		imgX += leftOrRight; //More movement.
		
		
		
		batch.draw(img, imgX, imgY);
		
		batch.end(); //End, send to graphics card. All drawing code above.
	}
}
