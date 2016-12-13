package com.wall_ball.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

/**
 * Created by kaliuser on 12.12.16.
 */

public class InputText extends ApplicationAdapter implements TextInputListener {
    final Ball game;
    String text;
    boolean notparsed = false;
    boolean notcanceled = false;
    //boolean logged = false;

    @Override
    public void create () {
        Gdx.input.getTextInput(this, "Push your record at record table", "", "Enter your name");
        notparsed = true;
    }
    public InputText(Ball game) {

        this.game = game;

    }



    @Override
    public void input(String text) {

                    this.text = text;
        notcanceled = true;
        //Gdx.app.log("text", text);
    }

    @Override
    public void canceled() {
        //text = "canceled";
        //Gdx.app.log("text", text);
        notcanceled = false;
        game.setScreen(game.wb);


    }
/*  public boolean Logged()
  {
      return logged;
  }*/
/*    public void callText(){



        //return text;
    }*/
}
