package com.wall_ball.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class WallBall implements Screen {

    final Ball game;
    SpriteBatch batch;
    OrthographicCamera camera;



    int counter = 0;


    Texture ball_img;
    Texture gameimg;

    Texture ring_img;

    Texture longhorizontal_img, longvertical_img, shorthorizontal_img, red_img;
    Sound snd;

    Rectangle ball_rect, black_r, ring_r;

    public WallBall(final Ball game) {

        this.game = game;
        batch = new SpriteBatch();

        snd = Gdx.audio.newSound(Gdx.files.internal("kick.wav"));

        ring_img = new Texture("ring.png");
        ball_img = new Texture((Gdx.files.internal("ball.png")));
        longhorizontal_img = new Texture(Gdx.files.internal("lh.png"));
        longvertical_img = new Texture(Gdx.files.internal("lv.png"));
        shorthorizontal_img = new Texture(Gdx.files.internal("sh.png"));
        red_img = new Texture("red.png");
        gameimg = new Texture(Gdx.files.internal("wallball.png"));


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        ball_rect = new Rectangle();
        ball_rect.x = 400;
        ball_rect.y = 240;
        ball_rect.width = 60;
        ball_rect.height = 60;

        black_r = new Rectangle();
        black_r.x = 410 - 60 / 2;
        black_r.y = 440;
        black_r.width = 60;
        black_r.height = 40;

        ring_r = new Rectangle();
        ring_r.width = 40;
        ring_r.height = 40;
        ring_r.x = MathUtils.random(80, 700);
        ring_r.y = MathUtils.random(80, 400);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


            camera.update();
            batch.setProjectionMatrix(camera.combined);
            batch.begin();

            batch.draw(ball_img, ball_rect.x, ball_rect.y);

            batch.draw(shorthorizontal_img, 38, 440);
            batch.draw(shorthorizontal_img, 420, 440);
            batch.draw(longvertical_img, 0, 0);
            batch.draw(longvertical_img, 760, 0);
            batch.draw(longhorizontal_img, 40, -5);
            batch.draw(red_img, black_r.x, black_r.y);
            batch.draw(ring_img, ring_r.x, ring_r.y);
            game.font.draw(batch, "Total score: " + counter, 40, 440);
            batch.end();


            float x = Gdx.input.getPitch();

            float y = Gdx.input.getRoll();

            if (x < 0) {

                ball_rect.x += Gdx.graphics.getDeltaTime() * 300;
            } else {

                ball_rect.x -= Gdx.graphics.getDeltaTime() * 300;
            }

            if (y > -40) {

                ball_rect.y += Gdx.graphics.getDeltaTime() * 300;
            } else {
                ball_rect.y -= Gdx.graphics.getDeltaTime() * 300;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A))
                ball_rect.x -= 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.D))
                ball_rect.x += 600 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.W))
                ball_rect.y += 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.S))
                ball_rect.y -= 600 * Gdx.graphics.getDeltaTime();




            if (ball_rect.x < 40) ball_rect.x = 40;
            if (ball_rect.x > 700) ball_rect.x = 700;
            if (ball_rect.y < 40) ball_rect.y = 40;
            if (ball_rect.x < black_r.x - black_r.width / 2 || ball_rect.x > black_r.x + black_r.width / 2) {
                if (ball_rect.y > 384) ball_rect.y = 384;
            } else if (ball_rect.y > 384) {

                game.ts = new InputText(game);
                Gdx.app.log("i = ", Integer.toString(game.rs.i));
                ball_rect.x = MathUtils.random(80, 700);
                ball_rect.y = 0;
                game.setScreen(game.rs);

                game.ts.create();




                dispose();

            }
            if (ring_r.overlaps(ball_rect)) {
                snd.play();
                ring_r.x = MathUtils.random(80, 700);
                ring_r.y = MathUtils.random(80, 400);
                counter++;

            }




    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {




    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {



    }
}
