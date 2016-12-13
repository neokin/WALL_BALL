package com.wall_ball.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

/**
 * Created by kaliuser on 12.12.16.
 */

public class InputText implements TextInputListener {
    final Ball game;
    String text;
    boolean canceled = true;
    public InputText(Ball game) {

        this.game = game;

    }

    @Override
    public void input(String text) {

            this.text = text;
        canceled = false;


    }

    @Override
    public void canceled() {

        game.setScreen(game.wb);
        canceled = true;
    }

    public String getText(){

        Gdx.input.getTextInput(this, "Push your record at record table", "", "Enter your name");

        return text;
    }
}
