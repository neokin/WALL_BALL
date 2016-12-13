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
    //PauseScreen ps;
    @Override
    public void create() {
        batch = new SpriteBatch();

        font = new BitmapFont();
        //ts = new InputText(this);
        ms = new MenuScreen(this);
        wb = new WallBall(this);
        rs = new RecordScreen(this);
       // ps = new PauseScreen(this);

        setScreen(ms);
        //this.setScreen(new MenuScreen(this));
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
       // ps.dispose();
    }


}
