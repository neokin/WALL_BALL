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
    int i;
    // float d = 4f;
    Array<String> records = new Array<String>();

    public RecordScreen(Ball game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        recimg = new Texture(Gdx.files.internal("records2.png"));
        // i = 320;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        i = 380;
         //this.resume();

        game.setScreen(game.rs);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(recimg, 0, 320);


        if (game.ts.notparsed && game.ts.notcanceled) {
            username = game.ts.text;
            s = username + " : " + game.wb.counter;
            records.add(s);
            //game.wb.i -= 20;
            game.ts.notparsed = false;
        }

        for (String record : records) {
            game.font.draw(game.batch, record, 400, i);
            i-=20;
        }


        // game.setScreen(game.rs);

        game.batch.end();
        //else game.setScreen(game.rs);
        if (Gdx.input.isTouched()) {

            game.setScreen(game.wb);
            //game.wb.anim = true;

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
