package com.wall_ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by kaliuser on 11.12.16.
 */

public class RecordScreen implements Screen {
    final Ball game;
    Texture recimg;
    OrthographicCamera camera;
    public RecordScreen(Ball game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        recimg = new Texture(Gdx.files.internal("records2.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(recimg, 0, 320);
        //game.font.setColor(0, 1, 0, 10);
        //game.font.draw(game.batch, "Just touch the screen", 350, 255);
        game.batch.end();
        if (Gdx.input.isTouched()) {
           // game.ms.dispose();
           // game.ms = new MenuScreen(game.ms.game);
            game.setScreen(game.ms);
           // dispose();
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
