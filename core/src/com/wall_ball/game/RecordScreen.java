package com.wall_ball.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;


public class RecordScreen implements Screen {
    final Ball game;
    Texture recimg;
    String s, username;
    OrthographicCamera camera;

   // float d = 4f;
    Array<String> records  = new Array<String>();
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
        if(game.ts.notparsed && game.ts.notcanceled) {
            // this.resume();
            Gdx.gl.glClearColor(0, 0, 0.2f, 1);

            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            camera.update();
            game.batch.setProjectionMatrix(camera.combined);

            game.batch.begin();
            game.batch.draw(recimg, 0, 320);

            username = game.ts.text;
            s = username + " : " + game.wb.counter;
            records.add(s);
            //records.
            int i = 300;
            for (String record : records) {
                game.font.draw(game.batch, record, 350, i);
                i -= 20;
            }

            game.batch.end();
            game.ts.notparsed = false;
        }
            if (Gdx.input.isTouched()) {

                game.setScreen(game.wb);

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
