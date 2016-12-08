package com.wall_ball.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

//import static com.badlogic.gdx.math.MathUtils.round;

public class WALL_BALL extends ApplicationAdapter {

	SpriteBatch batch;
	OrthographicCamera camera;

	static float x0;
	int counter;
	static float y0;
	Texture ball_img;
	Texture longhorizontal_img, longvertical_img, shorthorizontal_img, red_img;
	Sound snd;
	Music msc;
	Vector3 newPos = new Vector3();
	Rectangle ball_rect, longhorizontal_r, longvertical_1, longvertical_2, shorthorizontal_1, shorthorizontal_2, red_r;

	@Override
	public void create () {
		batch = new SpriteBatch();

		counter = 1;
		snd = Gdx.audio.newSound(Gdx.files.internal("congrat.mp3"));
		//msc = Gdx.audio.newMusic(Gdx.files.internal("main.mp3"));

		ball_img = new Texture((Gdx.files.internal("ball.png")));
		longhorizontal_img = new Texture(Gdx.files.internal("longhorizontal.png"));
		longvertical_img = new Texture(Gdx.files.internal("longvertical.png"));
		shorthorizontal_img = new Texture(Gdx.files.internal("shorthorizontal.png"));
		red_img = new Texture("red.png");


		//msc.setLooping(true);
		//msc.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		ball_rect = new Rectangle();
		ball_rect.x = 400;
		ball_rect.y = 240;
		ball_rect.width = 60;
		ball_rect.height = 60;

		longhorizontal_r = new Rectangle();
		longhorizontal_r.x = 40;
		longhorizontal_r.y = 0;
		longhorizontal_r.width = 720;
		longhorizontal_r.height = 40;

		shorthorizontal_1 = new Rectangle();
		shorthorizontal_1.x = 40;
		shorthorizontal_1.y = 440;
		shorthorizontal_1.width = 320;
		shorthorizontal_1.height = 40;

		shorthorizontal_2 = new Rectangle();
		shorthorizontal_2.x = 440;
		shorthorizontal_2.y = 440;
		shorthorizontal_2.width = 320;
		shorthorizontal_2.height = 40;

		longvertical_1 = new Rectangle();
		longvertical_1.x = 0;
		longvertical_1.y = 0;
		longvertical_1.width = 40;
		longvertical_1.height = 480;

		longvertical_2 = new Rectangle();
		longvertical_2.x = 760;
		longvertical_2.y = 0;
		longvertical_2.width = 40;
		longvertical_2.height = 480;

		red_r = new Rectangle();
		red_r.x = 410-60/2;
		red_r.y = 440;
		red_r.width = 60;
		red_r.height = 40;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(ball_img, ball_rect.x, ball_rect.y);
		batch.draw(longhorizontal_img, longhorizontal_r.x, longhorizontal_r.y);
		batch.draw(shorthorizontal_img, shorthorizontal_1.x, shorthorizontal_1.y);
		batch.draw(shorthorizontal_img, shorthorizontal_2.x, shorthorizontal_2.y);
		batch.draw(longvertical_img, longvertical_1.x, longvertical_1.y);
		batch.draw(longvertical_img, longvertical_2.x, longvertical_2.y);
		batch.draw(longvertical_img, longvertical_2.x, longvertical_2.y);
		batch.draw(red_img, red_r.x, red_r.y);
		batch.end();






		//newPos.set(x, y, 0);
		//camera.unproject(newPos);
		float x = Gdx.input.getPitch();
		//float y = Gdx.input.getAzimuth();
		float y = Gdx.input.getRoll();
		//if(counter%12 == 0) {
			//if (Math.abs(y - ball_rect.y) >= 0 || Math.abs(x - ball_rect.x) >= 0) {
				if (x < 0) {
					ball_rect.x = (ball_rect.x + 3);
				} else ball_rect.x = (ball_rect.x - 3);
				if (y >-40) {
					ball_rect.y = (ball_rect.y + 3);
				} else ball_rect.y = (ball_rect.y - 3);

				newPos.set(ball_rect.x, ball_rect.y, 0);
				camera.unproject(newPos);

			System.out.println("x = " + x);
			System.out.println("y = " + y);

		//}



		if(ball_rect.x < 40) ball_rect.x = 40;
		if(ball_rect.x > 800 - 60 - 40) ball_rect.x = 800 - 60 - 40;
		if(ball_rect.y < 40) ball_rect.y = 40;
		if(ball_rect.x< red_r.x - red_r.width/2 || ball_rect.x> red_r.x +red_r.width/2) {
			if (ball_rect.y > 480 - 60 - 40) ball_rect.y = 480 - 60 - 40;
		}




		else if (ball_rect.y > 480 - 60 - 40) {
			//snd.play();

		}
		counter = counter + 1;

	}
	
	@Override
	public void dispose () {
		batch.dispose();

		snd.dispose();


	}
}
