package com.wall_ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;


public class MenuScreen implements Screen {

    final Ball game;
    Texture gameimg;
    OrthographicCamera camera;
    //float d = 4f;

    public MenuScreen(Ball game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        gameimg = new Texture(Gdx.files.internal("wallball.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(gameimg, 310, 260);
        game.font.setColor(0, 1, 0, 10);
        game.font.draw(game.batch, "Just touch the screen", 350, 255);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(game.wb);

            dispose();
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
        //gameimg.dispose();

    }
}
