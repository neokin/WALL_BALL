package com.wall_ball.game;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Ball extends Game {
    SpriteBatch batch;
    BitmapFont font;

    MenuScreen ms;
    WallBall wb;
    RecordScreen rs;
    InputText ts;

    @Override
    public void create() {
        batch = new SpriteBatch();

        font = new BitmapFont();

        ms = new MenuScreen(this);
        wb = new WallBall(this);
        rs = new RecordScreen(this);


        setScreen(ms);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        ms.dispose();
        wb.dispose();
        rs.dispose();

    }


}
